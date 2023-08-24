package com.example.borrowbooks.controller;

import com.example.borrowbooks.model.Book;
import com.example.borrowbooks.model.User;
import com.example.borrowbooks.service.BookService;
import com.example.borrowbooks.service.IBookService;
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
@RequestMapping("book")
public class BookController {
    @Autowired
    IBookService service;
    @GetMapping("")
    public String showProductList(@RequestParam(defaultValue = "0",required = false)int page, Model model, @RequestParam("id") int id) {
        Pageable pageable = PageRequest.of(page,3);
        Page<Book> book = service.findAll(pageable);
        model.addAttribute("book", book);
        model.addAttribute("id",id);
        return "books";
    }
    @GetMapping("/create")
    public String addList(Model model) {
        model.addAttribute("book", new Book());
        return "createbook";
    }
    @PostMapping("/create")
    public String add(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        service.create(book);
        redirectAttributes.addFlashAttribute("mess","Thêm Mới Thành Công");
        return "redirect:/user";
    }
}
