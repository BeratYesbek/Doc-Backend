package com.doc.doc_backend.api;

import com.doc.doc_backend.business.abstracts.INewsFileService;
import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.core.utilities.concretes.Result;
import com.doc.doc_backend.core.utilities.concretes.SuccessDataResult;

import com.doc.doc_backend.entities.concretes.News;
import com.doc.doc_backend.entities.concretes.NewsFile;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private DataResult<NewsFile> add(@RequestParam MultipartFile[] multipartFiles, @RequestParam int news_id) throws IOException {
        NewsFile newsFile = new NewsFile();
        News news = new News();
        news.setNews_id(news_id);
        newsFile.setNews(news);

        newsFileService.add(newsFile, multipartFiles);
        return new SuccessDataResult(null);
    }

    @PostMapping("/update")
    private Result update(@RequestParam MultipartFile[] multipartFiles, @RequestParam String newsFile) throws JSONException, ParseException {
        JSONParser parser = new JSONParser(newsFile);
        JSONObject json = (JSONObject) parser.parse();

        JSONArray array = new JSONArray(newsFile);
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            System.out.println("dsa");
        }
        return null;
    }

    private Result delete(@RequestParam NewsFile newsFile) {
        return null;
    }
}
