package com.luv2code.springboot.demo.mycoolapp.repository;

import com.luv2code.springboot.demo.mycoolapp.entity.FileUploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface FileUploadRepository extends JpaRepository<FileUploadEntity, Long>{
    List<FileUploadEntity> findAll();
}
