package com.doc.doc_backend.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
public class NewsFileDto {

    private int id;

    private int news_id;

    private String file_path;

    private MultipartFile multipartFile[];
}
