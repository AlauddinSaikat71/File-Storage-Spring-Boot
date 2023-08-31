package com.luv2code.springboot.demo.mycoolapp.controller;

import com.luv2code.springboot.demo.mycoolapp.entity.ShareWithMeEntity;
import com.luv2code.springboot.demo.mycoolapp.model.*;
import com.luv2code.springboot.demo.mycoolapp.service.ShareWithMeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@RestController
@Validated
@RequestMapping("/share")
public class ShareWithMeController {

    @Autowired
    private ShareWithMeService shareWithMeService;

    @PostMapping()
    public ApiResponse<ShareWithMeEntity> shareFileWithSomeone(@RequestBody @Valid CreateShareWithMeDTO body){
        try {
            ShareWithMeEntity newShareWithMeEntity = this.shareWithMeService.shareFileWithSomeone(body);

            ApiResponse<ShareWithMeEntity> resposne = new ApiResponse<>(true,PostStatus.FILE_SHARE_SUCCESS.getMessage(), newShareWithMeEntity);
            return resposne;
        } catch (Exception e) {
            //throw e;
            return new ApiResponse(false, PostStatus.FILE_SHARE_ERROR.getMessage(), e);
        }

    }

    @PatchMapping("/{id}")
    public ApiResponse<ShareWithMeEntity> updateShareWithMe(@PathVariable("id") Long id, @RequestBody @Valid UpdateShareWithMeDTO body) {
        try{
            ShareWithMeEntity updatedShareWithMeEntity = this.shareWithMeService.updateShareWithMe(id, body);

            ApiResponse<ShareWithMeEntity> resposne = new ApiResponse<>(true, UpdateStatus.UPDATE_SUCCESS.getMessage(), updatedShareWithMeEntity);
            return resposne;
        }catch (Exception e){
            return new ApiResponse(false, UpdateStatus.UPDATE_ERROR.getMessage(), e);
        }
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteShareWithMe(@PathVariable("id") Long id){
        try{
            this.shareWithMeService.deleteShareWithMe(id);
            ApiResponse response = new ApiResponse(true, DeleteStatus.DELETE_SUCCESS.getMessage());
            return response;
        }catch (Exception e){
            return new ApiResponse(false, DeleteStatus.DELETE_ERROR.getMessage(), e);
        }
    }
}
