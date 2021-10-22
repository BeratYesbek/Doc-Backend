package com.doc.doc_backend.dataAccess.abstracts;

import com.doc.doc_backend.entities.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentDao extends JpaRepository<Comment, Integer> {
}
