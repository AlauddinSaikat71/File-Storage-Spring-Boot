package com.luv2code.springboot.demo.mycoolapp.model;

public enum DataRetriveStatus {
    SUCCESS("Data retrieved successfully!"),
    ERROR("Error retrieving data");

    private final String message;

    DataRetriveStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
