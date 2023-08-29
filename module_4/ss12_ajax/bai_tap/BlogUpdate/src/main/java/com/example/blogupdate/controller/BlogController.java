package com.example.blogupdate.controller;


import com.example.blogupdate.model.Blog;
import com.example.blogupdate.model.Category;
import com.example.blogupdate.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("blog")
public class BlogController {
    @Autowired
    IBlogService service;

    @GetMapping("")
    public String showProductList(@RequestParam(defaultValue = "0",required = false)int page, Model model) {
        Pageable pageable = PageRequest.of(page,3);
        Page<Blog> blogList = service.findAll(pageable);
        List<Category> categories = service.findAllCategory();
        model.addAttribute("category", categories);
        model.addAttribute("blogs", blogList);
        return "list";
    }
    @GetMapping("/blog")
    public String showProductListt(Model model) {
        List<Blog> blogList = service.findAll();
        model.addAttribute("blogs", blogList);
        return "ajax";
    }
    @GetMapping("/search")
    public String showProductList(@RequestParam String name, Model model,@RequestParam(defaultValue = "0",required = false)int page) {
        Pageable pageable = PageRequest.of(page,3);
        Page<Blog> blogList = service.findCategoryName(name,pageable);
        List<Category> categories = service.findAllCategory();
        model.addAttribute("category", categories);
        model.addAttribute("blogs", blogList);
        return"list";
    }


    @GetMapping("/category/{id}")
    public String showProductListCategory(Model model, @PathVariable int id,@RequestParam(defaultValue = "0",required = false)int page) {
        Pageable pageable = PageRequest.of(page,3);
        Page<Blog> blogList = service.findCategory(id,pageable);
        List<Category> categories = service.findAllCategory();
        model.addAttribute("category", categories);
        model.addAttribute("blogs", blogList);
        return "list";
    }

    @GetMapping("/views/{id}")
    public String viewList(Model model, @PathVariable int id) {
        model.addAttribute("blog", service.findById(id));
        return "view";
    }

    @GetMapping("/create")
    public String addList(Model model) {
        List<Category> categories = service.findAllCategory();
        model.addAttribute("category", categories);
        model.addAttribute("blogs", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String add(Blog blogs) {
        service.create(blogs);
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String editList(Model model, @PathVariable int id) {
        List<Category> categories = service.findAllCategory();
        model.addAttribute("category", categories);
        model.addAttribute("blogs", service.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Blog blog) {
        service.edit(blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/blog";
    }
}
