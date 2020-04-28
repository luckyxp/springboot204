package com.xp.springboot204.controller;

import com.xp.springboot204.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Climb.Xu
 * @date 2020/4/27 21:20
 */
@ControllerAdvice
public class MyExceptionHandler {
    //如果这么写,就没有自适应效果,即浏览器和其他客户端都返回json
    //    @ExceptionHandler(UserNotFoundException.class)
    //    @ResponseBody
    //    public Map<String, Object> handlerException(Exception e) {
    //        Map<String, Object> map = new HashMap<>();
    //        map.put("code", "user.notexiist");
    //        map.put("message", e.getMessage());
    //        return map;
    //    }

    @ExceptionHandler(UserNotFoundException.class)
    public String handlerException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "user.notexiist");
        map.put("sss", "fsdfasdf");
        map.put("status", "500");
        map.put("message", e.getMessage());

        //BasicErrorController源码: Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
        request.setAttribute("javax.servlet.error.status_code", 500); //这个地方要自己设置状态码 不然默认是200,就匹配不到对应的错误页面

        request.setAttribute("ext", map); //将所有的json值放到request,在后面自定义一个ErrorAttributes进行处理
        return "forward:/error"; //这样就可以让 BasicErrorController给我们做自适应
    }
}
