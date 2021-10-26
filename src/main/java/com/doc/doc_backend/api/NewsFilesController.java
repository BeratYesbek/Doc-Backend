package com.doc.doc_backend.api;

import com.doc.doc_backend.business.abstracts.INewsFileService;
import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.core.utilities.concretes.Result;
import com.doc.doc_backend.core.utilities.concretes.SuccessDataResult;

import com.doc.doc_backend.entities.concretes.News;
import com.doc.doc_backend.entities.concretes.NewsFile;
import com.doc.doc_backend.entities.dtos.NewsFileDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/news_files")
public class NewsFilesController {

    private INewsFileService newsFileService;

    @Autowired
    public NewsFilesController(INewsFileService newsFileService) {
        this.newsFileService = newsFileService;
    }

    @PostMapping("/add")
    private DataResult add(@ModelAttribute NewsFileDto newsFileDto) throws IOException {

        NewsFile newsFile = new Gson().fromJson(newsFileDto.getNewsFile(), NewsFile.class);
        return newsFileService.add(newsFile, newsFileDto.getMultipartFile());
    }

    @PostMapping("/update")
    private Result update(@ModelAttribute NewsFileDto newsFileDto) {
        NewsFile[] newsFile = new Gson().fromJson(newsFileDto.getNewsFile(), NewsFile[].class);
        return newsFileService.update(newsFile, newsFileDto.getMultipartFile());
    }

    @PostMapping("/delete")
    private Result delete(@RequestParam NewsFile[] newsFile) {
        return newsFileService.delete(newsFile);
    }

    @GetMapping("/getById")
    private DataResult<NewsFile> getById(int id) {
        return newsFileService.getById(id);
    }

    @GetMapping("/getAll")
    private DataResult<List<NewsFile>> getAll() {
        return newsFileService.getAll();
    }
}
