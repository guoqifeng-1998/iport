package xg.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import xg.beans.LogData;
import xg.beans.UserManager;
import xg.dao.LogTool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ControllerAdvice
public class getResponseAdvice implements ResponseBodyAdvice<Object> {
    @Autowired
    LogTool log;

    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest request, ServerHttpResponse serverHttpResponse) {
        System.out.println("进入beforeBodyWrite方法");

        //获取session和session数据
        ServletServerHttpRequest r= (ServletServerHttpRequest) request;
        HttpServletRequest req=r.getServletRequest();
        HttpSession session=req.getSession();
        UserManager u=(UserManager)session.getAttribute("user");
        if(u==null){
            System.out.println("你还没登录。。。");
            return body;
        }

        LogData data=new LogData();
        data.setUsername(u.getUsername());

        //a解析操作类型
        parseOPerType(req,data);
        parseOperModule(req,data);
        if(data.getModuleName()==null||data.getOperType()==null){
            return body;
        }

        //解析操作结果是否成功
        parseResult(body,data);
        log.insertLog(data);
        System.out.println("===========data:"+data+"=================");
        return body;
    }

    //a解析操作类型
    void parseOPerType(HttpServletRequest req,LogData data){
        String operType=null;
        switch (req.getMethod()){
            case "POST":
                operType="添加";
                break;
            case "DELETE":
                operType="删除";
                break;
            case "PUT":
                operType="修改";
        }
        data.setOperType(operType);
    }
    //解析操作模块和操作内容
    void parseOperModule(HttpServletRequest req,LogData data){
        String url=req.getServletPath();
        System.out.println("url==========:"+url);
        int end=url.indexOf('/',1);
        String module=null;
        // 示例：/sys/role,获取sys字符串
        switch (url.substring(1,end)){
            case "sys":
                module="系统管理";
                break;
            case "item":
                module="项目管理";
                break;
            case "model":
                module="模型管理";
                break;
            case "dev":
                module="资产管理";
                break;
            case "alarm":
                module="报警管理";
        }
        data.setModuleName(module);

        //解析操作内容
        int end2=url.indexOf('/',end+1);
        //如果没找到第三个/，如/sys/org，则取到尾部
        end2=end2<0?url.length():end2;
        String content=url.substring(end+1,end2);
        data.setOperContent(content);
    }

    //解析操作是否成功
    void parseResult(Object body,LogData data){
        boolean rs=false;
        if (body instanceof AjaxResult) {
            AjaxResult result = (AjaxResult) body;
            rs=result.isSuccess();
        }
        data.setResult(rs);
    }
}
