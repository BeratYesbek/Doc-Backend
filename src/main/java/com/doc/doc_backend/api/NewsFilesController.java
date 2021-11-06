package com.doc.doc_backend.api;
import com.doc.doc_backend.business.abstracts.INewsFileService;
import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.core.utilities.concretes.Result;
import com.doc.doc_backend.entities.concretes.NewsFile;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/api/news_files")
public class NewsFilesController {

    private INewsFileService newsFileService;

    @Autowired
    public NewsFilesController(INewsFileService newsFileService) {
        this.newsFileService = newsFileService;
    }

    @PostMapping("/add")
    private DataResult add(@RequestParam String newsFiles, @RequestParam MultipartFile[] multipartFiles)  {

        NewsFile newsFile = new Gson().fromJson(newsFiles, NewsFile.class);
        return newsFileService.add(newsFile, multipartFiles);
    }

    @PostMapping("/update")
    private Result update(@RequestParam String newsFiles, @RequestParam MultipartFile[] multipartFiles) {
        NewsFile[] newsFile = new Gson().fromJson(newsFiles, NewsFile[].class);
        return newsFileService.update(newsFile, multipartFiles);
    }

    @PostMapping("/delete")
    private Result delete(@RequestBody NewsFile[] newsFile) {
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
