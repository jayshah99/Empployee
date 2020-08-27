package com.example.Employee2.util.exceptions;

import com.example.Employee2.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<Response> handleInvalidRequest(InvalidRequestException ex) {
        return new ResponseEntity<>(
                new Response(true, ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler({Employee2Exception.class, IOException.class})
    public ResponseEntity<Response> handleInvalidRequest(Exception ex) {

        String message;
        if (ex instanceof IOException) {
            message = "Unable to process your request now. Please try again later.";
        } else
            message = ex.getMessage();

        return new ResponseEntity<>(
                new Response(true, message),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Response> handleInvalidRequest(NotFoundException ex) {
        return new ResponseEntity<>(
                new Response(true, ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}
