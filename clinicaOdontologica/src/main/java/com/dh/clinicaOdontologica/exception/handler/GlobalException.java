package com.dh.clinicaOdontologica.exception.handler;
import com.dh.clinicaOdontologica.exception.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler({Exceptions.class})
    public ResponseEntity<String> errorResourceNotFound(Exceptions exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
