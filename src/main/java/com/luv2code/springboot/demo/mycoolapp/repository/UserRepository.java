package com.luv2code.springboot.demo.mycoolapp.repository;

import com.luv2code.springboot.demo.mycoolapp.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
//    @Autowired
//    default UserEntity getUserById(Long id){
//        return findById(id);
//    }
}
