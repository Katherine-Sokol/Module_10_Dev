package com.goit.exception;

public class CrudServiceException extends RuntimeException {

    public CrudServiceException(String message) {
        super(message);
    }
}
