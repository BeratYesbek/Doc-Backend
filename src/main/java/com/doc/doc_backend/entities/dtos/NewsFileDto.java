package com.doc.doc_backend.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


public class NewsFileDto {

    //private int id;

    // private int news_id;

    private String newsFile;

    //private String file_path;

    private MultipartFile[] multipartFile;

    public String getNewsFile() {
        return newsFile;
    }

    public void setNewsFile(String newsFile) {
        this.newsFile = newsFile;
    }

    public MultipartFile[] getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile[] multipartFile) {
        this.multipartFile = multipartFile;
    }
}
