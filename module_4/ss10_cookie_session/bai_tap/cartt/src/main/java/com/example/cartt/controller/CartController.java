package com.example.cartt.controller;

import com.example.cartt.model.Cartt;
import com.example.cartt.model.Product;
import com.example.cartt.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController {
    @ModelAttribute("cart")
    public Cartt initiCart() {
        return new Cartt();
    }

    @Autowired
    ICartService service;

    @GetMapping("")
    public String showProductList(Model model) {
        List<Cartt> carttList = service.list();
        model.addAttribute("cart", carttList);
        return "cart";
    }

    @GetMapping("/create")
    public String showProductList(Model model, @RequestParam int id) {
        List<Cartt> carttList = service.listId(id);
        if (carttList.size() == 0) {
            service.listIdCreate(id);
        } else {
            service.idCreate(id);
        }
        model.addAttribute("cart", carttList);
        return "redirect:/product";
    }

    @GetMapping("/success")
    public String success() {
        service.success();
        return "redirect:/product";
    }
}
