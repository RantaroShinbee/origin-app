package com.ea.origin.store.exception;

import java.io.IOException;

public class FileNotFoundException extends IOException {
    
    private int code;

    public int getCode() {
        return code;
    }

    public FileNotFoundException (int code) {
        this.code = code;
    }

    public FileNotFoundException(int code, String message) {
        super(message);
        this.code = code;
    }

    public FileNotFoundException(int code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public FileNotFoundException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}