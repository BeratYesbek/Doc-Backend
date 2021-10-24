package com.doc.doc_backend.api;

import com.doc.doc_backend.business.abstracts.INewsFileService;
import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.core.utilities.concretes.Result;
import com.doc.doc_backend.core.utilities.concretes.SuccessDataResult;
import com.doc.doc_backend.core.utilities.fileHelper.FileExtension;
import com.doc.doc_backend.core.utilities.fileHelper.FileHelperService;
import com.doc.doc_backend.core.utilities.fileHelper.IFileHelperService;
import com.doc.doc_backend.entities.concretes.News;
import com.doc.doc_backend.entities.concretes.NewsFile;
import com.doc.doc_backend.entities.dtos.NewsFileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/news_files")
public class NewsFilesController {

    private INewsFileService newsFileService;

    @Autowired
    public NewsFilesController(INewsFileService newsFileService) {
        this.newsFileService = newsFileService;
    }

    @PostMapping("/add")
    private DataResult<NewsFile> add(@RequestParam MultipartFile[] multipartFiles, @RequestParam int news_id) throws IOException {
        NewsFile newsFile = new NewsFile();
        News news = new News();
        news.setNews_id(news_id);
        newsFile.setNews(news);

        newsFileService.add(newsFile,multipartFiles);
        return new SuccessDataResult(null);
    }

    private Result update(@RequestParam NewsFileDto newsFileDto) {
        return null;
    }

    private Result delete(@RequestParam NewsFileDto newsFileDto) {
        return null;
    }
}
