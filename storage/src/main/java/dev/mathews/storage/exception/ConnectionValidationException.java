package dev.mathews.storage.exception;

public class ConnectionValidationException extends Exception {

    public ConnectionValidationException() {
        super("Connection validation failed");
    }
}
