package com.luv2code.springboot.demo.mycoolapp.common.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static java.time.Instant.from;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now().atZone(ZoneId.systemDefault()).toLocalDateTime();
        this.updatedAt = this.createdAt;
        //this.createdBy = getCurrentUser();
        this.updatedBy = this.createdBy;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
        //this.updatedBy = getCurrentUser();
    }

    /**
     * @return current user id
     */
//    private String getCurrentUser() {
//        //Check if user is anonymous
//        boolean isAnonymous = false;
//        //Get current user
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        //Check if user is authenticated
//        if (authentication != null) {
//            for (GrantedAuthority authority : authentication.getAuthorities()) {
//                if (authority.getAuthority().equals("ROLE_ANONYMOUS")) {
//                    isAnonymous = true;
//                }
//            }
//            if (authentication.isAuthenticated() && !isAnonymous) {
//                User user = (User) authentication.getPrincipal();
//                return String.valueOf(user.getId());
//            } else {
//                return "1";
//            }
//        } else {
//            // user is not authenticated, handle the error
//            return "1";
//        }
//    }

}
