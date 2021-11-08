package com.doc.doc_backend.api;

import com.doc.doc_backend.business.abstracts.ICommentService;
import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.core.utilities.concretes.ErrorDataResult;
import com.doc.doc_backend.core.utilities.concretes.Result;
import com.doc.doc_backend.entities.concretes.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {

    private ICommentService commentService;

    public CommentsController(ICommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add")
    private DataResult<Comment> add(@RequestBody Comment comment) {
        return this.commentService.add(comment);
    }

    @PostMapping("/update")
    private Result update(@RequestBody Comment comment) {
        return this.commentService.update(comment);
    }

    @PostMapping("/delete")
    private Result delete(@RequestBody Comment comment) {
        return this.commentService.delete(comment);
    }

    @GetMapping("/getById")
    private DataResult<Comment> getById(int id) {
        return this.commentService.getById(id);
    }

    @GetMapping("/getAll")
    private DataResult<List<Comment>> getAll() {
        return this.commentService.getAll();
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
