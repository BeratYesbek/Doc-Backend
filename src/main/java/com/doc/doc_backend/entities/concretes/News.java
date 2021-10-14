package com.doc.doc_backend.entities.concretes;

import com.doc.doc_backend.entities.abstracts.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@Data
@Table(name = "news")
public class News implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    //private ArrayList<String> liked;

    //private ArrayList<String> disliked;

    @Column(name = "published_date")
    private Date published_date;

    @Column(name = "description")
    private String description;

    @Column(name = "source_link")
    private String source_link;

    @JoinColumn(name = "id")
    @ManyToOne
    private User user;

}