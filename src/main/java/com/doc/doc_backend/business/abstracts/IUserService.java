package com.doc.doc_backend.business.abstracts;

import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.core.entities.User;

public interface IUserService extends IServiceRepository<User> {
    DataResult<User> findByEmail(String email);
}
