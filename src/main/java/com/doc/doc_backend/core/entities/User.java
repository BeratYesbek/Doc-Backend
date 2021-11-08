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
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
    @NotBlank
    @Email(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    private String email;


    @Column(name = "first_name")
    @NotBlank
    @Length(min = 2, max = 15)
    private String first_name;

    @Column(name = "last_name")
    @NotBlank
    @Length(min = 2, max = 15)
    private String last_name;

    @Column(name = "password")
    @NotBlank
    @Length(min = 8, max = 25)
    private String password;

    @Column(name = "date_of_birth")
    @NotBlank
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
