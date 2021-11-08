package com.doc.doc_backend.api;

import com.doc.doc_backend.business.abstracts.INewsService;
import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.core.utilities.concretes.ErrorDataResult;
import com.doc.doc_backend.core.utilities.concretes.Result;
import com.doc.doc_backend.entities.concretes.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors
                = new ErrorDataResult<Object>(validationErrors,"Validation Errors");
        return errors;
    }
}
