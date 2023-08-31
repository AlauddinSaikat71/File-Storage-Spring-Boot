package com.luv2code.springboot.demo.mycoolapp.model;


import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NonNull;

@Data
public class CreateShareWithMeDTO {
    @NonNull
    @Positive
    private Long fileId;

    @NonNull
    @Positive
    private Long ownerId;

    @NonNull
    @Positive
    private Long userId;

    @NonNull
    private FileAccess fileAccess;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public FileAccess getFileAccess() {
        return fileAccess;
    }

    public void setFileAccess(FileAccess fileAccess) {
        this.fileAccess = fileAccess;
    }
}
