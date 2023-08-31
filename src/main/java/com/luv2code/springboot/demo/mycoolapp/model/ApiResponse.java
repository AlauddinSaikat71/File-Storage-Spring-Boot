package com.luv2code.springboot.demo.mycoolapp.model;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class ApiResponse<T> implements Serializable {
    private Boolean isSuccess;
    private String message;
    private Error error;
    private T results;

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    public ApiResponse(Boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public ApiResponse(Boolean isSuccess, String message, T results) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.results = results;
    }

    public ApiResponse(Boolean isSuccess, String message, Error error) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.error = error;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
