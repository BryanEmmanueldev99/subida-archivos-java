package com.file.api.service;


import org.springframework.web.multipart.MultipartFile;


public interface IUploadFileService {


    String handleFileUpload(MultipartFile file) throws Exception;

}
