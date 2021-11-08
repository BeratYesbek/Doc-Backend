package com.doc.doc_backend.api;

import com.doc.doc_backend.business.abstracts.IUserOperationClaimService;
import com.doc.doc_backend.core.entities.UserOperationClaim;
import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.core.utilities.concretes.ErrorDataResult;
import com.doc.doc_backend.core.utilities.concretes.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/userOperationClaims")
public class UserOperationClaimsController {

    private IUserOperationClaimService userOperationClaimService;

    @Autowired
    public UserOperationClaimsController(IUserOperationClaimService userOperationClaimService) {
        this.userOperationClaimService = userOperationClaimService;
    }

    @PostMapping("/add")
    private DataResult<UserOperationClaim> add(@RequestBody UserOperationClaim userOperationClaim) {
        return this.userOperationClaimService.add(userOperationClaim);
    }

    @PostMapping("/update")
    private Result update(@RequestBody UserOperationClaim userOperationClaim) {
        return this.userOperationClaimService.update(userOperationClaim);
    }

    @PostMapping("/delete")
    private Result delete(@RequestBody UserOperationClaim userOperationClaim) {
        return this.userOperationClaimService.delete(userOperationClaim);
    }

    @GetMapping("/getById")
    private DataResult<UserOperationClaim> getById(int id) {
        return this.userOperationClaimService.getById(id);
    }

    @GetMapping("/getAll")
    private DataResult<List<UserOperationClaim>> getAll() {
        return this.userOperationClaimService.getAll();
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
