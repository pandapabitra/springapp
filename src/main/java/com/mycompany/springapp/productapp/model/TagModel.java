package com.mycompany.springapp.productapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "TAG_TABLE")
public class TagModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TAG_NAME")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "tags")
    private Set<PostModel> posts = new HashSet<>();

    public TagModel() {
    }

    public TagModel(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PostModel> getPosts() {
        return posts;
    }

    public void setPosts(Set<PostModel> posts) {
        this.posts = posts;
    }
}
