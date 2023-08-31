package com.luv2code.springboot.demo.mycoolapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luv2code.springboot.demo.mycoolapp.common.entity.BaseEntity;
import com.luv2code.springboot.demo.mycoolapp.model.FileAccess;
import jakarta.persistence.*;
import org.hibernate.annotations.Where;

@Entity
@Table(name= "share_with_me")
@Where(clause = "is_deleted = false OR is_deleted is null")
public class ShareWithMeEntity extends BaseEntity {

    @Column
    private Long fileId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private UserEntity owner;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Column(name = "file_access")
    @Enumerated(EnumType.STRING)
    private FileAccess fileAccess;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public FileAccess getFileAccess() {
        return fileAccess;
    }

    public void setFileAccess(FileAccess fileAccess) {
        this.fileAccess = fileAccess;
    }
}
