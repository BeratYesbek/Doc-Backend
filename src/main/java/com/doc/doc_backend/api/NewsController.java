package com.doc.doc_backend.api;

import com.doc.doc_backend.business.abstracts.INewsService;
import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.core.utilities.concretes.Result;
import com.doc.doc_backend.entities.concretes.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @PostMapping("/update")
    private Result update(@RequestBody News news) {
        return newsService.update(news);
    }

    @PostMapping("/delete")
    private Result delete(@RequestBody News news){
        return newsService.delete(news);
    }

    @GetMapping("/getById")
    private DataResult<News> getById(int id){
        return newsService.getById(id);
    }

    @GetMapping("/getAll")
    private DataResult<List<News>> getAll() {
        return newsService.getAll();
    }

}
