package com.example.borrowbooks.controller;

import com.example.borrowbooks.exception.BorrowBooksException;
import com.example.borrowbooks.model.BorrowBooks;
import com.example.borrowbooks.service.IBorowBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("borrowbooks")
public class BorrowBooksController {
    @Autowired
    IBorowBooksService service;

    @GetMapping("")
    public String showProductList(@RequestParam("id") int id, @RequestParam("iduser") int iduser, Model model) {
        service.create(id, iduser);
        return "redirect:/user";
    }

    @GetMapping("/view")
    public String showProductList(@RequestParam(defaultValue = "0", required = false) int page, Model model, @RequestParam("id") int id) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<BorrowBooks> borrowBooks = service.findAlll(pageable, id);
        model.addAttribute("borrowbooks", borrowBooks);
        model.addAttribute("id", id);
        return "borrowbooks";
    }
    @PostMapping("/delete")
    public String deleteList(Model model, @RequestParam("id") int id, @RequestParam(defaultValue = "0", required = false) int bookId,
                             RedirectAttributes redirectAttributes) throws BorrowBooksException {
        List<BorrowBooks> books = service.findBook(id,bookId);
        if(books.size()==0){
            return "book_error";
        }
        service.delete(id, bookId);
        return "redirect:/user";
    }


    @ExceptionHandler(BorrowBooksException.class)
    private String BorrowBooks() {
        return "book_error";
    }


}
