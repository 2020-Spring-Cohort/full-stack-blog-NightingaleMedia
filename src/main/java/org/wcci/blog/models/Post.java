package org.wcci.blog.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Category category;

}
