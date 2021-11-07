package com.doc.doc_backend.api;

import com.doc.doc_backend.business.abstracts.IUserOperationClaimService;
import com.doc.doc_backend.core.entities.UserOperationClaim;
import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.core.utilities.concretes.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
