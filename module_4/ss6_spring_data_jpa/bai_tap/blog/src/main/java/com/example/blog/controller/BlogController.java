package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("blog")
public class BlogController {
    @Autowired
    IBlogService service;

    @GetMapping("")
    public String showProductList(Model model) {
        List<Blog> blogList = service.findAll();
        List<Category> categories = service.findAllCategory();
        model.addAttribute("category", categories);
        model.addAttribute("blogs", blogList);
        return "list";
    }

    @GetMapping("/category/{id}")
    public String showProductListCategory(Model model, @PathVariable int id) {
        List<Blog> categories = service.findCategory(id);
        model.addAttribute("category", categories);
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
        service.create(blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/blog";
    }
}
