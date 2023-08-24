package com.example.borrowbooks.controller;

import com.example.borrowbooks.model.Book;
import com.example.borrowbooks.model.User;
import com.example.borrowbooks.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    IUserService service;
    @GetMapping("")
    public String showProductList(@RequestParam(defaultValue = "0",required = false)int page, Model model) {
        Pageable pageable = PageRequest.of(page,3);
        Page<User> users = service.findAll(pageable);
        model.addAttribute("user", users);
        return "index";
    }
    @GetMapping("/create")
    public String addList(Model model) {
        model.addAttribute("user", new User());
        return "createuse";
    }
    @PostMapping("/create")
    public String add(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        service.create(user);
        redirectAttributes.addFlashAttribute("mess","Thêm Mới User Thành Công");
        return "redirect:/user";
    }
}
