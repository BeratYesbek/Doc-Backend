package com.doc.doc_backend.dataAccess.abstracts;
import com.doc.doc_backend.entities.concretes.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILikeDao extends JpaRepository<Like, Integer> {
}
