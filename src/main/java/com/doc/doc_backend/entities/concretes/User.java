package com.doc.doc_backend.entities.concretes;

import com.doc.doc_backend.entities.abstracts.IEntity;
<<<<<<< HEAD
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
    private int user_id;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "users")
public class User implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<News> news;
}
