package com.example.blogupdate.service;



import com.example.blogupdate.model.Blog;
import com.example.blogupdate.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
     void edit(Blog blogs) ;
    Page<Blog> findAll(Pageable pageable);
    List<Blog> findAll();

    Blog findById(int id);

    void create(Blog blogs);

    void delete(int id);

    Page<Blog> findCategory(int id,Pageable pageable);
    List<Blog> findCategory(int id);

    List<Category> findAllCategory();

    Page<Blog> findCategoryName(String name, Pageable pageable);
    List<Blog> findCategoryName(String name);

    Blog findBlog(int id);

    List<Blog> loadMoreBlogs(int start, int count);
}
