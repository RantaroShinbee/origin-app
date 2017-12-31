package com.ea.origin.store.exception;

public class InvalidParameterException extends Exception {

    private int code;

    public int getCode() {
        return code;
    }

    public InvalidParameterException (int code) {
        this.code = code;
    }

    public InvalidParameterException(int code, String message) {
        super(message);
        this.code = code;
    }

    public InvalidParameterException(int code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public InvalidParameterException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

}