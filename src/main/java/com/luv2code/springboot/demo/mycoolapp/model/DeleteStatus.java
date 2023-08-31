package com.luv2code.springboot.demo.mycoolapp.model;

public enum DeleteStatus {
    DELETE_SUCCESS("File uploaded successfully!"),
    DELETE_ERROR("Error uploading file");

    private final String message;

    DeleteStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
