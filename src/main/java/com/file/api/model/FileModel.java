package com.file.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_uploads")
public class FileModel {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       @Column(name = "path")
       private String namefile;


    public FileModel() {
    }


    public FileModel(Long id, String namefile) {
        this.id = id;
        this.namefile = namefile;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamefile() {
        return this.namefile;
    }

    public void setNamefile(String namefile) {
        this.namefile = namefile;
    }

}
