package com.doc.doc_backend.dataAccess.abstracts;

import com.doc.doc_backend.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User, Integer> {
}
