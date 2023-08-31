package com.luv2code.springboot.demo.mycoolapp.service;

import com.luv2code.springboot.demo.mycoolapp.entity.FileUploadEntity;
import com.luv2code.springboot.demo.mycoolapp.entity.UserEntity;
import com.luv2code.springboot.demo.mycoolapp.repository.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FileUploadSevice {
    @Autowired
    private FileUploadRepository fileUploadRepository;

    @Autowired
    private UserService userService;
    private final String uploadDir = "uploads";

    public FileUploadEntity saveFileUpload(MultipartFile file, Long ownerId, String uploadPath) {
        try {
            UserEntity owner = this.userService.getUserById(ownerId).get();
            if (owner != null) {
                FileUploadEntity fileUpload = new FileUploadEntity();
                fileUpload.setFileName(file.getOriginalFilename());
                fileUpload.setFileType(file.getContentType());
                fileUpload.setPath(uploadPath);
                fileUpload.setOwner(owner);

                System.out.println(owner.getName() + "           "+owner.getId() + "     " + fileUpload.getOwner().getName());

                return fileUploadRepository.save(fileUpload);
            } else {
                throw new RuntimeException("Owner not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Could not save file upload", e);
        }
    }
    public FileUploadEntity storeFile(MultipartFile file, Long ownerId) throws IOException {

        Path uploadPath = Paths.get(uploadDir + "/" + ownerId) ;
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        try {
            Path filePath = uploadPath.resolve(Objects.requireNonNull(file.getOriginalFilename()));

            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return this.saveFileUpload(file, ownerId, filePath.toString());
        } catch (IOException e) {
            throw new IOException("Could not store file " + file.getOriginalFilename(), e);
        }
    }

    public List<FileUploadEntity> getAll() throws IOException {
        try{
            List<FileUploadEntity> fileUploadList= fileUploadRepository.findAll();
            return fileUploadList;
        } catch (Exception e){
            throw new IOException("Could not get files ", e);
        }
    }
}
