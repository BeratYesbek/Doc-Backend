package com.doc.doc_backend.entities.concretes;

import com.doc.doc_backend.entities.abstracts.IEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "news")
public class News implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    private int news_id;

    @Column(name = "published_date")
    private Date published_date;

    @Column(name = "description")
    private String description;

    @Column(name = "source_link")
    private String source_link;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "news")
    private List<NewsFile> newsFiles;

    @JsonManagedReference
    @OneToMany(mappedBy = "news")
    private List<Like> likes;

    @JsonManagedReference
    @OneToMany(mappedBy = "news")
    private List<Dislike> dislikes;


}
