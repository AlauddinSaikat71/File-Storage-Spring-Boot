package com.luv2code.springboot.demo.mycoolapp.service;

import com.luv2code.springboot.demo.mycoolapp.entity.UserEntity;
import com.luv2code.springboot.demo.mycoolapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public Optional<UserEntity> getUserById(Long id) {
        Optional<UserEntity> user = this.userRepository.findById(id);

        if(user!= null){
            return user;
        }else{
            return null;
        }
    }

    public List<UserEntity> getAll(){
        return this.userRepository.findAll();
    }
}
