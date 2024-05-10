package de.aittr.shop.exception_handlig.exceotions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//2 СПОСОБ ОБРАБОТКИ исключений
// + быстро и удобно без лишнего кода создаем глобальный обработчик исключения
// - клиент не видит детализированного сообщения об ошибке, следовательно затрудняется анализ причин ее возникновения

@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class SecondTestException extends RuntimeException{

    public SecondTestException(String message){
        super(message);
    }
}
