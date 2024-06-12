package com.spring_scope.scpring.scope.controller;

import com.spring_scope.scpring.scope.component.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginForm() {
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean logIn = loginProcessor.login();
        if (logIn) {
            model.addAttribute("message", "Ты залогинен!");
        } else {
            model.addAttribute("message", "Ты не прошел аутентификацию");
        }
        return "login.html";
    }
}
