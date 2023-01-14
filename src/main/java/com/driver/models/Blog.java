package com.driver.models;

import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.util.*;

@Entity
@Table
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String title;

    private String content;

    @CreationTimestamp
    private Date createdOn;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<Image> imageList;

    public Blog() {
    }

    public Blog(int id, String title, String content, Date createdOn, User user, List<Image> imageList) {
        this.Id = id;
        this.title = title;
        this.content = content;
        this.createdOn = createdOn;
        this.user = user;
        this.imageList = imageList;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

}