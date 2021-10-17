package com.doc.doc_backend.entities.concretes;

import com.doc.doc_backend.entities.abstracts.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.GenerationType;
import javax.persistence.*;

@AllArgsConstructor
@Data
@Table(name = "news_files")
public class NewsFile implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_file_id")
    private int news_file_id;

    @Column(name = "file_path")
    private String file_path;

    @Column(name = "news_id")
    private int news_id;

    @JoinColumn(name = "news_id")
    @ManyToMany
    private News news;
}
