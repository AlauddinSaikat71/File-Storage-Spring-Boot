package com.luv2code.springboot.demo.mycoolapp.repository;

import com.luv2code.springboot.demo.mycoolapp.entity.ShareWithMeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface ShareWithMeRepository extends JpaRepository<ShareWithMeEntity, Long> {

    List<ShareWithMeEntity> findAll();
}