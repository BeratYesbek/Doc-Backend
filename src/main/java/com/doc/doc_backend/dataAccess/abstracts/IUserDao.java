package com.doc.doc_backend.dataAccess.abstracts;

import com.doc.doc_backend.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
