package com.doc.doc_backend.api;

import com.doc.doc_backend.business.abstracts.ILikeService;
import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.core.utilities.concretes.ErrorDataResult;
import com.doc.doc_backend.core.utilities.concretes.Result;
import com.doc.doc_backend.entities.concretes.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/likes")
public class LikesController {

    private ILikeService likeService;

    @Autowired
    public LikesController(ILikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/add")
    private DataResult<Like> add(@Valid @RequestBody Like like) {

        return likeService.add(like);
    }

    @PostMapping("/update")
    private Result update(@Valid @RequestBody Like like) {

        return likeService.update(like);
    }

    @PostMapping("/delete")
    private Result delete(@RequestBody Like like) {

        return likeService.delete(like);
    }

    @GetMapping("/getById")
    private DataResult<Like> getById(int id) {
        return likeService.getById(id);
    }

    @GetMapping("/getAll")
    private DataResult<List<Like>> getAll() {
        return likeService.getAll();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors
                = new ErrorDataResult<Object>(validationErrors, "Validation Errors");
        return errors;
    }

}
