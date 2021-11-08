package com.doc.doc_backend.entities.concretes;

import com.doc.doc_backend.core.entities.User;
import com.doc.doc_backend.entities.abstracts.IEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank
    private Date published_date;

    @Column(name = "description")
    @Length(min = 100, max = 500)
    @NotBlank
    private String description;

    @Column(name = "source_link")
    @NotBlank
    @URL
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

    @JsonIgnore
    @OneToMany(mappedBy = "news")
    private List<Comment> comments;

}
