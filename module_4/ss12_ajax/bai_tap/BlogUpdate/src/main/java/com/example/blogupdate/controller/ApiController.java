package com.example.blogupdate.controller;

import com.example.blogupdate.model.Blog;
import com.example.blogupdate.model.Category;
import com.example.blogupdate.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/blog")
public class ApiController {

    @Autowired
    private IBlogService service;

    @GetMapping("")
    public ResponseEntity<List<Blog>> showProductList() {
        List<Blog> blogs = service.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> showCategoryList() {
        List<Category> categories = service.findAllCategory();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Blog>> showProductListCategoryById(@PathVariable int id) {
        List<Blog> blogList = service.findCategory(id);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> showProductBLogById(@PathVariable int id) {
        Blog blogList = service.findBlog(id);
        if (blogList== null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    @GetMapping("/blog/search/{name}")
    public ResponseEntity<List<Blog>> showProductBLogById(@PathVariable String name) {
        List<Blog> blogList = service.findCategoryName(name);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/loadMore/{start}/{count}")
    public ResponseEntity<List<Blog>> loadMoreBlogs(
            @PathVariable int start,
            @PathVariable int count
    ) {
        List<Blog> blogs = service.loadMoreBlogs(start, count);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }



}
