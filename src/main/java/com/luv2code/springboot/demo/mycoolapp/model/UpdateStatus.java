package com.luv2code.springboot.demo.mycoolapp.model;

public enum UpdateStatus {
    UPDATE_SUCCESS("File uploaded successfully!"),
    UPDATE_ERROR("Error uploading file");
    private final String message;

    UpdateStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
