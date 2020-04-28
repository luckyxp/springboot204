package com.xp.springboot204.config;

import com.xp.springboot204.component.LoginHandlerInterceptor;
import com.xp.springboot204.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author Climb.Xu
 * @date 2020/4/4 11:31
 */
//使用WebMvcConfigurer (WebMvcConfigurerAdapter已弃用)可以扩展springMvc的功能,以及修改默认配置
//@EnableWebMvc 全面接管SpringMVC]
@Configuration
public class MyMvcConfig implements WebMvcConfigurer{
    //    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("index");
//    }
    //所有的WebMvcConfigurer都会一起起作用
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            //注册视图解析器
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/dashboard.html").setViewName("dashboard");
            }
            //注册拦截器 springboot已经做好的静态资源映射
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor())
//                        .addPathPatterns("/**")
//                        .excludePathPatterns("/index.html","/","/user/login","/asserts/**","/webjars/**");
//            }
        };
        return webMvcConfigurer;
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
