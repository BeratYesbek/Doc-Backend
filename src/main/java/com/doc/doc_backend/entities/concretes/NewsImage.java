package com.doc.doc_backend.entities.concretes;

import com.doc.doc_backend.entities.abstracts.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.GenerationType;
import javax.persistence.*;

@AllArgsConstructor
@Data
@Table(name = "news_images")
public class NewsImage implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_image_id")
    private int news_image_id;

    @Column(name = "image_path")
    private String image_path;

    @Column(name = "news_id")
    private int news_id;

    @JoinColumn(name = "id")
    @ManyToMany
    private News news;
}
