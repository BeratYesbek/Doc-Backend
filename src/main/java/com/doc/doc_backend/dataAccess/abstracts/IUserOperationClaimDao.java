package com.doc.doc_backend.dataAccess.abstracts;

import com.doc.doc_backend.core.entities.UserOperationClaim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserOperationClaimDao extends JpaRepository<UserOperationClaim, Integer> {
    //List<UserOperationClaim> findAllByIdOrUserId(int id,int user_id);
    List<UserOperationClaim> getUserOperationClaimByUserUserId(int user_id);
}
