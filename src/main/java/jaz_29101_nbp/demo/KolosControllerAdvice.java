package jaz_29101_nbp.demo;

import jaz_29101_nbp.demo.Exceptions.NotFoudException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class KolosControllerAdvice {

    @ExceptionHandler(NotFoudException.class)
    public ResponseEntity<String> handleRuntimeException(NotFoudException ex)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Złe parametry!");
    }
}
