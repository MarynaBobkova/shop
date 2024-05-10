package de.aittr.shop.exception_handlig;

import de.aittr.shop.exception_handlig.exceotions.FourthTestException;
import de.aittr.shop.exception_handlig.exceotions.ThirdTestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

// 3 Способ обработки
@ControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(ThirdTestException.class)
    public ResponseEntity<Response> handleException(ThirdTestException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(FourthTestException.class)
    public ResponseEntity<Response> handleException(FourthTestException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.I_AM_A_TEAPOT);
    }
}
