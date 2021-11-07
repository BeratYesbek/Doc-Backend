package com.doc.doc_backend.core.entities;

import com.doc.doc_backend.entities.abstracts.IEntity;
import com.doc.doc_backend.entities.concretes.Comment;
import com.doc.doc_backend.entities.concretes.Dislike;
import com.doc.doc_backend.entities.concretes.Like;
import com.doc.doc_backend.entities.concretes.News;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@Table(name = "users")
@NoArgsConstructor
public class User implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "email")
    private String email;

    private String username;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "password")
    private String password;

    @Column(name = "date_of_birth")
    private Date date_of_birth;


    /*----------------------------------------------------------------------------------------------------------------*/
    @OneToMany(mappedBy = "user")
    private List<News> news;

    @OneToMany(mappedBy = "user")
    private List<Like> likes;

    @OneToMany(mappedBy = "user")
    private List<Dislike> dislikes;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @OneToMany(mappedBy = "user")
    private List<UserOperationClaim> userOperationClaims;

}
