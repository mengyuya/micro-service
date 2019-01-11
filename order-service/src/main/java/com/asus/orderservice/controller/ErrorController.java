package com.asus.orderservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
    @RequestMapping("/error/403")
    public String error() {
        return "/error/403";

    }

    @RequestMapping("/login")
    public String login() {
        return "/login";

    }
}
