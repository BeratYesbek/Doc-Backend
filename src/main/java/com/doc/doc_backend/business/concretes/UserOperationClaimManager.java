package com.doc.doc_backend.business.concretes;

import com.doc.doc_backend.business.abstracts.IUserOperationClaimService;
import com.doc.doc_backend.core.entities.UserOperationClaim;
import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.core.utilities.concretes.Result;
import com.doc.doc_backend.core.utilities.concretes.SuccessDataResult;
import com.doc.doc_backend.core.utilities.concretes.SuccessResult;
import com.doc.doc_backend.dataAccess.abstracts.IUserOperationClaimDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserOperationClaimManager implements IUserOperationClaimService {
    private IUserOperationClaimDao userOperationClaimDao;

    @Autowired
    public UserOperationClaimManager(IUserOperationClaimDao userOperationClaimDao) {
        this.userOperationClaimDao = userOperationClaimDao;
    }

    @Override
    public DataResult<UserOperationClaim> add(UserOperationClaim entity) {
        UserOperationClaim userOperationClaim = userOperationClaimDao.save(entity);
        return new SuccessDataResult(entity);
    }

    @Override
    public Result update(UserOperationClaim entity) {
        userOperationClaimDao.save(entity);
        return new SuccessResult("User operation claim has been updated successfully");
    }

    @Override
    public Result delete(UserOperationClaim entity) {
        userOperationClaimDao.delete(entity);
        return new SuccessResult("User Operation Claim has been deleted successfully");
    }

    @Override
    public DataResult<UserOperationClaim> getById(int id) {
        return new SuccessDataResult(userOperationClaimDao.getById(id));
    }

    @Override
    public DataResult<List<UserOperationClaim>> getAll() {
        return new SuccessDataResult(userOperationClaimDao.findAll());
    }

    @Override
    public List<UserOperationClaim> findByUserId(int user_id) {
        List<UserOperationClaim> operationClaims = userOperationClaimDao.getUserOperationClaimByUserUserId(user_id);
        return operationClaims;
    }
}
