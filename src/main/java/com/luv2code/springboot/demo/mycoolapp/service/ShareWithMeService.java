package com.luv2code.springboot.demo.mycoolapp.service;

import com.luv2code.springboot.demo.mycoolapp.entity.ShareWithMeEntity;
import com.luv2code.springboot.demo.mycoolapp.entity.UserEntity;
import com.luv2code.springboot.demo.mycoolapp.model.CreateShareWithMeDTO;
import com.luv2code.springboot.demo.mycoolapp.model.UpdateShareWithMeDTO;
import com.luv2code.springboot.demo.mycoolapp.repository.ShareWithMeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShareWithMeService {
    @Autowired
    public UserService userService;
    @Autowired
    public ShareWithMeRepository shareWithMeRepository;

    public ShareWithMeEntity shareFileWithSomeone(CreateShareWithMeDTO createShareWithMeDTO){
        try{
            UserEntity owner = this.userService.getUserById(createShareWithMeDTO.getOwnerId()).get();
            UserEntity user = this.userService.getUserById(createShareWithMeDTO.getUserId()).get();

            ShareWithMeEntity shareWithMeEntity = new ShareWithMeEntity();

            shareWithMeEntity.setFileId(createShareWithMeDTO.getFileId());
            shareWithMeEntity.setOwner(owner);
            shareWithMeEntity.setUser(user);
            shareWithMeEntity.setFileAccess(createShareWithMeDTO.getFileAccess());

            return shareWithMeRepository.save(shareWithMeEntity);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public ShareWithMeEntity updateShareWithMe(Long id, UpdateShareWithMeDTO updateShareWithMeDTO ) throws ChangeSetPersister.NotFoundException {
        try{
            Optional<ShareWithMeEntity> optionalShareWithMeEntity = this.shareWithMeRepository.findById(id);

            if(optionalShareWithMeEntity.isPresent()){
                ShareWithMeEntity shareWithMeEntity = optionalShareWithMeEntity.get();
                shareWithMeEntity.setFileAccess(updateShareWithMeDTO.getFileAccess());

                return this.shareWithMeRepository.saveAndFlush(shareWithMeEntity);
            } else {
                throw new ChangeSetPersister.NotFoundException();
            }
        }catch (Exception e){
            throw e;
        }
    }

    public void deleteShareWithMe(Long id){
        try{
            this.shareWithMeRepository.deleteById(id);
        }catch (Exception e){
            throw e;
        }
    }
}
