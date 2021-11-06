package com.doc.doc_backend.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


public class NewsFileDto {


    private String newsFile;

    public MultipartFile[] multipartFiles;

    public String getNewsFile() {
        return newsFile;
    }

    public void setNewsFile(String newsFile) {
        this.newsFile = newsFile;
    }

    public MultipartFile[] getMultipartFile() {
        return multipartFiles;
    }

    public void setMultipartFile(MultipartFile[] multipartFile) {
        this.multipartFiles = multipartFile;
    }
}
