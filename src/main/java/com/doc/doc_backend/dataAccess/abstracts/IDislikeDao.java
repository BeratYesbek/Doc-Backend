package com.doc.doc_backend.dataAccess.abstracts;

import com.doc.doc_backend.entities.concretes.Dislike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDislikeDao extends JpaRepository<Dislike, Integer> {
}
