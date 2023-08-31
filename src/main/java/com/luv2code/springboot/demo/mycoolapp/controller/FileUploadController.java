package com.luv2code.springboot.demo.mycoolapp.controller;

import com.luv2code.springboot.demo.mycoolapp.model.ApiResponse;
import com.luv2code.springboot.demo.mycoolapp.model.DataRetriveStatus;
import com.luv2code.springboot.demo.mycoolapp.model.PostStatus;
import com.luv2code.springboot.demo.mycoolapp.entity.FileUploadEntity;
import com.luv2code.springboot.demo.mycoolapp.repository.UserRepository;
import com.luv2code.springboot.demo.mycoolapp.service.FileUploadSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/files")
public class FileUploadController {
    @Autowired
    FileUploadSevice fileUploadSevice;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/upload")
    public ApiResponse<FileUploadEntity> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("ownerId") Long ownerId) {
        try {
            FileUploadEntity fileUpload = this.fileUploadSevice.storeFile(file, ownerId);

            ApiResponse<FileUploadEntity> resposne = new ApiResponse<>(true, PostStatus.FILE_UPLOAD_SUCCESS.getMessage(), fileUpload);
            return resposne;
        } catch (Exception e) {
            //throw e;
            return new ApiResponse(false, PostStatus.FILE_UPLOAD_ERROR.getMessage(), e);
        }
    }

    @GetMapping()
    public ApiResponse getAll() {
        try{
            List<FileUploadEntity> fileUploads = this.fileUploadSevice.getAll();

            ApiResponse response = new ApiResponse(true, DataRetriveStatus.SUCCESS.getMessage(), fileUploads);
            return response;
        } catch (Exception e){
            return new ApiResponse(false,DataRetriveStatus.ERROR.getMessage(), e);
            //throw new IOException("Could not get files ", e);
        }
    }
}
