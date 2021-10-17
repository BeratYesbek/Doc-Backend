package com.doc.doc_backend.entities.concretes;

import com.doc.doc_backend.entities.abstracts.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@Table(name = "news")
@NoArgsConstructor
=======
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@Data
@Table(name = "news")
>>>>>>> 30349c71e9b5ff0b36891f0a5a7454a7b7c6cd82
public class News implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    @Column(name = "news_id")
    private int news_id;
=======
    @Column(name = "id")
    private int id;
>>>>>>> 30349c71e9b5ff0b36891f0a5a7454a7b7c6cd82

    //private ArrayList<String> liked;

    //private ArrayList<String> disliked;

    @Column(name = "published_date")
    private Date published_date;

    @Column(name = "description")
    private String description;

    @Column(name = "source_link")
    private String source_link;

<<<<<<< HEAD
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;
=======
    @JoinColumn(name = "id")
    @ManyToOne
    private User user;

>>>>>>> 30349c71e9b5ff0b36891f0a5a7454a7b7c6cd82
}
