package com.doc.doc_backend.business.abstracts;

import com.doc.doc_backend.core.entities.UserOperationClaim;

import java.util.List;

public interface IUserOperationClaimService extends IServiceRepository<UserOperationClaim> {
    List<UserOperationClaim> findByUserId(int user_id);

}
