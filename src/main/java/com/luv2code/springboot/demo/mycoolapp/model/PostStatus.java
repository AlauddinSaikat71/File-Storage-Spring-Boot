package com.luv2code.springboot.demo.mycoolapp.model;

public enum PostStatus {
    FILE_UPLOAD_SUCCESS("File uploaded successfully!"),
    FILE_UPLOAD_ERROR("Error uploading file"),
    FILE_SHARE_SUCCESS("File shared successfully"),
    FILE_SHARE_ERROR("Error sharing file");

    private final String message;

    PostStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}