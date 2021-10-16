package com.doc.doc_backend.api;

import com.doc.doc_backend.business.abstracts.INewsService;
import com.doc.doc_backend.entities.concretes.News;
import com.doc.doc_backend.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/news")
@Controller
public class NewsController {

    private INewsService newsService;

    @Autowired
    public NewsController(INewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping("/add")
    private DataResult<News> add(@RequestBody News news) {
        return newsService.add(news);
    }
}
