package com.hf.springbootblogrestapi.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class blogApiException extends  RuntimeException{
    @Getter
    private HttpStatus httpStatus;
    private String message;

    public blogApiException(String message, HttpStatus httpStatus, String message1) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message1;
    }

    public blogApiException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
