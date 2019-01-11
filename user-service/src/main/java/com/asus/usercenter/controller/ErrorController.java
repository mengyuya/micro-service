package com.asus.usercenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController extends BaseController {
    @RequestMapping("/error/403")
    public String error() {
        return "/error/403";

    }

    @RequestMapping("/login")
    public String login() {
        return "/login";

    }

    @RequestMapping("/")
    public String index() {
        return "/index";
    }

}
