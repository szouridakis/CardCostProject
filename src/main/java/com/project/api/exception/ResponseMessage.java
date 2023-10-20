package com.project.api.exception;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ResponseMessage {
    private Date timestamp;
    private String message;
    private HttpStatus httpStatus;
    private int errorCode;

    public ResponseMessage() {

    }

    public ResponseMessage(Date timestamp, String message, HttpStatus httpStatus, int errorCode) {
        this.timestamp = timestamp;
        this.message = message;
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}