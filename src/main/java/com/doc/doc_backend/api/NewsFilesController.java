package com.doc.doc_backend.api;

import com.doc.doc_backend.business.abstracts.INewsFileService;
import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.core.utilities.concretes.Result;
import com.doc.doc_backend.entities.concretes.NewsFile;
import com.doc.doc_backend.entities.dtos.NewsFileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/news_files")
public class NewsFilesController {

    private INewsFileService newsFileService;

    @Autowired
    public NewsFilesController(INewsFileService newsFileService) {
        this.newsFileService = newsFileService;
    }

    private DataResult<NewsFile> add(@RequestParam NewsFileDto newsFileDto) {
        return null;
    }
    private Result update(@RequestParam NewsFileDto newsFileDto) {
        return null;
    }
    private Result delete(@RequestParam NewsFileDto newsFileDto) {
        return null;
    }
}
