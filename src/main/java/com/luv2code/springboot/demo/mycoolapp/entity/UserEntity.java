package com.luv2code.springboot.demo.mycoolapp.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.luv2code.springboot.demo.mycoolapp.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "users")

@Where(clause = "is_deleted = false OR is_deleted is null")
public class UserEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FileUploadEntity> files;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ShareWithMeEntity> sharedFiles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ShareWithMeEntity> sharedFilesWithMe;

    public List<ShareWithMeEntity> getSharedFilesWithMe() {
        return sharedFilesWithMe;
    }

    public void setSharedFilesWithMe(List<ShareWithMeEntity> sharedFilesWithMe) {
        this.sharedFilesWithMe = sharedFilesWithMe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<FileUploadEntity> getFiles() {
        return files;
    }

    public void setFiles(List<FileUploadEntity> files) {
        this.files = files;
    }

    public List<ShareWithMeEntity> getSharedFiles() {
        return sharedFiles;
    }

    public void setSharedFiles(List<ShareWithMeEntity> sharedFiles) {
        this.sharedFiles = sharedFiles;
    }

    @Override
    public String toString() {
        return "Files{" +
                "name='" +  getName()+ '\'' +
                ", id=" + getId() +
//                ", approval_status=" + getApprovalStatus() +
                '}';
    }
}
