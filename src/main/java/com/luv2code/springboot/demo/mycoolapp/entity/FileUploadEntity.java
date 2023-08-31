package com.luv2code.springboot.demo.mycoolapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luv2code.springboot.demo.mycoolapp.common.entity.BaseEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.Where;

import java.util.Optional;

@Entity
@Table(name= "file_upload_details")
@Where(clause = "is_deleted = false OR is_deleted is null")
public class FileUploadEntity extends BaseEntity {
    @Column
    private String fileName;

    @Column
    private String fileType;

    @Column
    private String path;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private UserEntity owner;

    public UserEntity getOwner() {
        return owner;
    }
    public FileUploadEntity() {

    }
    public FileUploadEntity(String fileName, String fileType, String path, UserEntity owner) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.path = path;
        this.owner = owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Files{" +
                "name='" +  fileName+ '\'' +
                ", Owner=" + getOwner().toString() +
//                ", approval_status=" + getApprovalStatus() +
                '}';
    }
}
