package com.luv2code.springboot.demo.mycoolapp.model;

import lombok.NonNull;

public class UpdateShareWithMeDTO {
    @NonNull
    private FileAccess fileAccess;

    public FileAccess getFileAccess() {
        return fileAccess;
    }

    public void setFileAccess(FileAccess fileAccess) {
        this.fileAccess = fileAccess;
    }
}
