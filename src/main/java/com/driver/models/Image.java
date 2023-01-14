package com.driver.models;

import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.util.*;

@Entity
@Table
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String description;

    private String dimension;

    @ManyToOne
    @JoinColumn
    private Blog blog;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Image(int id, String description, String dimension, Blog blog) {
        this.Id = Id;
        this.description = description;
        this.dimension = dimension;
        this.blog = blog;
    }

    public Image() {
    }

}