package com.file.api.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.file.api.repository.FileRepository;
import com.file.api.service.IUploadFileService;

@Service
public class UploadFileImpl implements IUploadFileService {

    @Autowired
    FileRepository fileRepository;

    @Override
    public String handleFileUpload(MultipartFile file) throws Exception {
            try {

                String filename = UUID.randomUUID().toString();
                byte[] bytes = file.getBytes();
                String originalname = file.getOriginalFilename();

                long fileSize = file.getSize();
                long maxFileSize = 5 * 1024 * 1024;


                if(fileSize > maxFileSize) {
                    return "El archivo no se pudo subir porque sobrepasa los 7MB";
                } else {

                    if(!originalname.endsWith(".jpg") && !originalname.endsWith(".png") 
                    && !originalname.endsWith(".jpeg") ) {
                    return "¡Formato invalido! Pruebe con otro.";
                    }

                    String fileExtension = originalname.substring(originalname.lastIndexOf("."));
                    String NewFileName = filename + fileExtension;

                    File folder = new File("src/main/resources/storage/java-uploads/");

                    if(!folder.exists()) {
                      folder.mkdirs();
                    }

                    Path path = Paths.get("src/main/resources/storage/java-uploads/" + NewFileName);
                    Files.write(path, bytes);

                    
                    return "¡Archivo subido y guardado con exito!";
                }     

            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
            
    }
          
       

}
