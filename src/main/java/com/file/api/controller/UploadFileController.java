package com.file.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.api.model.FileModel;
import com.file.api.repository.FileRepository;
import com.file.api.service.IUploadFileService;

@RestController
@RequestMapping("uploads/")
public class UploadFileController {

    @Autowired
    IUploadFileService iUploadFileService;

    @Autowired
    FileRepository fRepository;

    
   
    @PostMapping("file")
    public ResponseEntity<String> store_file(@RequestParam("file") MultipartFile file) throws Exception {
          return new ResponseEntity<>(iUploadFileService.handleFileUpload(file), HttpStatus.OK);
    }

    // @PostMapping("libro")
    // public String storeLibro(@RequestBody Libro libro) {
    //     // iTaskRepository.save(task);
    //     libroRepository.save(libro);
    //     return "¡Servicio agreado desde Spring Boot!";
    // }

    // @PostMapping("file")
    // public String store_file(MultipartFile file, @RequestBody FileModel fModel ) throws Exception {
    //       iUploadFileService.handleFileUpload(file);
    //       fRepository.save(fModel);
    //       return "Listo, ya se subio";
    // }

}
