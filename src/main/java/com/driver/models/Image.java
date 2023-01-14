package com.driver.models;

import javax.persistence.*;

@Entity
@Table
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String description;

    private String dimensions;

    @ManyToOne
    @JoinColumn
    private Blog blog;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimension) {
        this.dimensions = dimension;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Image(int Id, String description, String dimension, Blog blog) {
        this.Id = Id;
        this.description = description;
        this.dimensions = dimension;
        this.blog = blog;
    }

    public Image() {
    }

}