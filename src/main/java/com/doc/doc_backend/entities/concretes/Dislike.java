package com.doc.doc_backend.entities.concretes;

import com.doc.doc_backend.core.entities.User;
import com.doc.doc_backend.entities.abstracts.IEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "dislikes")
@AllArgsConstructor
@NoArgsConstructor
public class Dislike implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dislike_id")
    private int dislike_id;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @JoinColumn(name = "news_id")
    @ManyToOne
    @JsonBackReference
    private News news;

}
