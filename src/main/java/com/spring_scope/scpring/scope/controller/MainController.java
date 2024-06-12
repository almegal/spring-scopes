package com.spring_scope.scpring.scope.controller;

import com.spring_scope.scpring.scope.service.LoggedUserManegmentService;
import com.spring_scope.scpring.scope.service.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final LoggedUserManegmentService loggedUserManegmentService;
    private final LoginCountService countService;

    public MainController(LoggedUserManegmentService loggedUserManegmentService,
                          LoginCountService countService) {
        this.loggedUserManegmentService = loggedUserManegmentService;
        this.countService = countService;
    }

    @GetMapping("/main")
    public String getMainPage(
            @RequestParam(required = false) String Logout,
            Model model) {
        if (Logout != null) {
            loggedUserManegmentService.setUserName(null);
        }
        String userName = loggedUserManegmentService.getUserName();
        if (userName == null) {
            return "redirect:/";
        }
        // устанавливаем в представление атриббуте
        model.addAttribute("username", userName);
        model.addAttribute("loginCount", countService.getCount());
        return "main.html";
    }
}
