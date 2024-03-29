package com.example.blogupdate.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @OneToMany(mappedBy = "category")
    private List<Blog> blogs;

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
