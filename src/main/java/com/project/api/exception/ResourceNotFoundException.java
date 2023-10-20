package com.project.api.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException{

    private final HttpStatus status;
    private final int errorCode;

    public ResourceNotFoundException(String message) {
        super(message);
        this.status = HttpStatus.NOT_FOUND;
        this.errorCode = HttpStatus.NOT_FOUND.value();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
