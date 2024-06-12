package com.spring_scope.scpring.scope.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

// бин в области видимости веб приложения
// хранить информацию о количестве попыток авторизации
@Service
@ApplicationScope
public class LoginCountService {
    private int count;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
