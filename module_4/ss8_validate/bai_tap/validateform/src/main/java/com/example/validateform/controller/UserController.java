package com.example.validateform.controller;

import com.example.validateform.model.User;
import com.example.validateform.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    IUserService service;
    @GetMapping("")
    public String showProductList(@RequestParam(defaultValue = "0",required = false)int page, Model model) {
        Pageable pageable = PageRequest.of(page,3);
        Page<User> blogList = service.findAll(pageable);
        model.addAttribute("user", blogList);
        return "list";
    }
    @GetMapping("/create")
    public String addList(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }
    @PostMapping("/create")
    public String add(@Validated @ModelAttribute User user,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            return "create";
        }
        service.create(user);
        redirectAttributes.addFlashAttribute("mess","Thêm Mới Thành Công");
        return "redirect:/user";
    }
}
