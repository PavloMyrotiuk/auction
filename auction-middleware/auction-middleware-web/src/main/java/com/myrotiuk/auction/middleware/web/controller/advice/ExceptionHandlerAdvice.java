package com.myrotiuk.auction.middleware.web.controller.advice;

import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by pav on 2/15/15.
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    private static final String exceptionHeader = "exception";
    private static final String messageValue = "Something bad... very bad has happend .. Try again later.";

    @ExceptionHandler(value = DataAccessResourceFailureException.class)
    public ResponseEntity handelDbException() {
        ResponseEntity.HeadersBuilder headersBuilder = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        headersBuilder.header(exceptionHeader, messageValue);
        return headersBuilder.build();
    }
}
