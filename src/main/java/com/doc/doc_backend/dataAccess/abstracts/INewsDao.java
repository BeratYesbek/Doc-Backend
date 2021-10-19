package com.doc.doc_backend.dataAccess.abstracts;

import com.doc.doc_backend.entities.concretes.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface INewsDao extends JpaRepository<News,Integer> {

}
