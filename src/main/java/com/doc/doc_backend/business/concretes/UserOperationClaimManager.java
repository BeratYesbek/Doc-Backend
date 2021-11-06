package com.doc.doc_backend.business.concretes;

import com.doc.doc_backend.business.abstracts.IUserOperationClaimService;
import com.doc.doc_backend.core.entities.UserOperationClaim;
import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.core.utilities.concretes.Result;
import com.doc.doc_backend.dataAccess.abstracts.IUserOperationClaimDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOperationClaimManager implements IUserOperationClaimService {
    private IUserOperationClaimDao userOperationClaimDao;

    @Autowired
    public UserOperationClaimManager(IUserOperationClaimDao userOperationClaimDao) {
        this.userOperationClaimDao = userOperationClaimDao;
    }

    public UserOperationClaimManager() {

    }

    @Override
    public DataResult<UserOperationClaim> add(UserOperationClaim entity) {
        return null;
    }

    @Override
    public Result update(UserOperationClaim entity) {
        return null;
    }

    @Override
    public Result delete(UserOperationClaim entity) {
        return null;
    }

    @Override
    public DataResult<UserOperationClaim> getById(int id) {
        return null;
    }

    @Override
    public DataResult<List<UserOperationClaim>> getAll() {
        return null;
    }

    @Override
    public List<UserOperationClaim> findByUserId(int user_id) {
        List<UserOperationClaim> operationClaims = userOperationClaimDao.findByUser(user_id);
        return operationClaims;
    }
}
