package xg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import xg.beans.LogData;
import xg.beans.UserManager;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        UserManager u=(UserManager)req.getSession().getAttribute("user");
        if(u==null){
            req.getSession().setAttribute("msg","先登录");
            System.out.println("拦截器请你先登录。。。");
            System.out.println(req.getServletPath());
//            res.sendRedirect("/showIndex");
//            return false;
        }
        return true;
    }
}