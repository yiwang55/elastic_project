package com.imooc.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String loginPage(){
        return "user/login";
    }

    @GetMapping("/center")
    public String centerPage(){
        return "user/center";
    }

}
