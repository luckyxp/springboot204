package com.xp.springboot204.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Climb.Xu
 * @date 2020/4/28 9:58
 */
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("come on filter");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
