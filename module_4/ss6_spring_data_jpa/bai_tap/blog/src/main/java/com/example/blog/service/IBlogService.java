package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(int id);

    void create(Blog blogs);

    void delete(int id);

    List<Blog> findCategory(int name);

    List<Category> findAllCategory();
}
