package com.example.blogupdate.service;

import com.example.blogupdate.model.Blog;
import com.example.blogupdate.model.Category;
import com.example.blogupdate.repository.IBlogRepository;
import com.example.blogupdate.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository repository;
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Blog findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void create(Blog blogs) {
        repository.saveBlog(blogs.getDescribe(), blogs.getTitle(),blogs.getCategory().getId());
    }

    @Override
    public void edit(Blog blogs) {
        repository.save(blogs);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Blog> findCategory(int id,Pageable pageable) {
        return repository.findCategory(id,pageable);
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Blog> findCategoryName(String name, Pageable pageable) {
        return repository.findCategoryName("%"+name+"%",pageable);
    }
}
