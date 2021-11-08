package com.doc.doc_backend.api;

import com.doc.doc_backend.business.abstracts.IDislikeService;
import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.core.utilities.concretes.ErrorDataResult;
import com.doc.doc_backend.core.utilities.concretes.Result;
import com.doc.doc_backend.dataAccess.abstracts.IDislikeDao;
import com.doc.doc_backend.entities.concretes.Dislike;
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
@RequestMapping("/api/dislikes")
public class DislikesController {

    private IDislikeService dislikeService;

    @Autowired
    public DislikesController(IDislikeService dislikeService) {
        this.dislikeService = dislikeService;
    }


    @PostMapping("/add")
    private DataResult<Dislike> add(@Valid @RequestBody Dislike dislike) {
        return dislikeService.add(dislike);
    }

    @PostMapping("/update")
    private Result update(@Valid @RequestBody Dislike dislike) {
        return dislikeService.update(dislike);
    }

    @PostMapping("/delete")
    private Result delete(@Valid @RequestBody Dislike dislike) {
        return dislikeService.delete(dislike);
    }

    @GetMapping("/getById")
    private DataResult<Dislike> getById(int id) {
        return dislikeService.getById(id);
    }

    @GetMapping("/getAll")
    private DataResult<List<Dislike>> getAll() {
        return dislikeService.getAll();
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
