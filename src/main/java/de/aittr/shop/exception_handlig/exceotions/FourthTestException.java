package de.aittr.shop.exception_handlig.exceotions;

public class FourthTestException extends RuntimeException{

    public FourthTestException(String message) {
        super(message);
    }

    public FourthTestException(String message, Throwable cause) {
        super(cause);
    }
}
