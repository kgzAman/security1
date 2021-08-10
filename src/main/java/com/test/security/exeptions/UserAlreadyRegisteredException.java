package com.test.security.exeptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class UserAlreadyRegisteredException extends RuntimeException {

    public UserAlreadyRegisteredException(String msg) {
        super(msg);
    }
}
