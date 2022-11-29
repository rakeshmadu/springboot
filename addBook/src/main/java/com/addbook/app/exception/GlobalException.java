package com.addbook.app.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = UserException.class)
    @ResponseStatus
    @ResponseBody
    public ErrorResponse handleUserExistsException(UserException e) {
        return new ErrorResponse(1, e.getMessage());
    }

}