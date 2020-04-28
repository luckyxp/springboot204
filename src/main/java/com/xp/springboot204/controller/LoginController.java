package com.xp.springboot204.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author Climb.Xu
 * @date 2020/4/4 11:03
 */
@Controller
public class LoginController {
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        ModelMap modelMap,HttpSession session){
        if (username.equals("admin") && password.equals("123")){
            session.setAttribute("loginUser", username);
            return "redirect:/dashboard.html";
        }else {
            modelMap.addAttribute("msg", "账号或密码错误");
            return "login";
        }
    }
}
