package com.spring_scope.scpring.scope.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/")
    public String loginForm() {
        return "login.html";
    }
}
