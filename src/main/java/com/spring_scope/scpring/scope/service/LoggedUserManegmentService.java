package com.spring_scope.scpring.scope.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

// бин в облести видимости сессии
// хранить значение имени
@SessionScope
@Service
public class LoggedUserManegmentService {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
