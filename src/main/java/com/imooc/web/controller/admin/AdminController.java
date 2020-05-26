package com.imooc.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/center")
    public String adminCenter(){
        return "admin/center";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "admin/welcome";
    }

    @GetMapping("/login")
    public String login(){
        return "admin/login";
    }

}
