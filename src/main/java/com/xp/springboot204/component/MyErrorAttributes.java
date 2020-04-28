package com.xp.springboot204.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Climb.Xu
 * @date 2020/4/27 21:47
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);//获取父类的,即默认的json,也可以不用,那么返回的就只有自定义的json
//        Map<String, Object> errorAttributes = new HashMap<>(); //不用父类默认的,直接创建一个空的,如果不用默认的话,那么页面就取不到timestamp,status,error....等值
        Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0); //取出从自定义的异常处理器传过来的json返回 0代表在request中取,1session

        //把json值一个一个插入
        for (String s : ext.keySet()) {
            errorAttributes.put(s, ext.get(s));
        }

        return errorAttributes;
    }
}
