package com.file.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.file.api.model.FileModel;

public interface FileRepository extends JpaRepository<FileModel, Long> {

}
