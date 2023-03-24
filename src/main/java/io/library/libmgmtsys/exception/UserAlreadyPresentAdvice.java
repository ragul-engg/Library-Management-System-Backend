package io.library.libmgmtsys.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserAlreadyPresentAdvice {
    @ResponseBody
    @ExceptionHandler(UserAlreadyPresentException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String UserAlreadyPresentHandler(UserAlreadyPresentException ex) {
        return ex.getMessage();
    }
}