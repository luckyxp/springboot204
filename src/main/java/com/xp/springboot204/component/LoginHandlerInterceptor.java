package com.xp.springboot204.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Climb.Xu
 * @date 2020/4/4 20:13
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录状态判断
        Object user = request.getSession().getAttribute("loginUser");
        if (user != null) {
            return true;
        } else {
            request.setAttribute("msg", "没有权限,请先登录!");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }
    }
}
