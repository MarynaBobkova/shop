package de.aittr.shop.exception_handlig.exceotions;

public class FirstTestException extends RuntimeException {

    public FirstTestException() {

    }

    public FirstTestException(String message) {
        super(message);
    }

    public FirstTestException(String message, Throwable cause) {
        super(message, cause);
    }

}
