package com.spring_scope.scpring.scope.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
public class LoginProcessor {
    private Logger logger = LoggerFactory.getLogger(LoginProcessor.class);
    private String username;
    private String password;

    public boolean login() {
        logger.info("Using instance: MyBean@" + Integer.toHexString(System.identityHashCode(this)));
        String userName = this.username;
        String userPass = this.password;
        return "alexey".equalsIgnoreCase(userName) && "pass".equalsIgnoreCase(userPass);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
