package xg.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AjaxResult <T>{
    //操作是否成功
    private boolean success;
    /**
     * 操作执行后的提示
     */
    private String msg;
    /**
     * 执行操作后需要传递到页面的数据
     */
    private T obj;
}
