package com.spring_scope.scpring.scope.component;

import com.spring_scope.scpring.scope.service.LoggedUserManegmentService;
import com.spring_scope.scpring.scope.service.LoginCountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
public class LoginProcessor {
    // бин в области видимости сессии
    private final LoggedUserManegmentService service;
    // бин с областью видимости для всего приложения
    private final LoginCountService loginCountService;
    // для логирования
    private final Logger logger = LoggerFactory.getLogger(LoginProcessor.class);

    private String username;
    private String password;

    public LoginProcessor(LoggedUserManegmentService service, LoginCountService loginCountService) {
        this.service = service;
        this.loginCountService = loginCountService;
    }

    // метод проверки пользвателя
    public boolean login() {
        loginCountService.increment();
        logger.info("Using instance: MyBean@" + Integer.toHexString(System.identityHashCode(this)));
        // проверяем что данные подходят
        if ("alexey".equalsIgnoreCase(username) && "pass".equalsIgnoreCase(password)) {
            // устанавливаем для сессии значение имени и возращаем true
            service.setUserName(username);
            return true;
        }
        // иначе
        return false;
    }

    /* getters and setters */
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
