package com.example.product_upgrade.controller;


import com.example.product_upgrade.model.Product;
import com.example.product_upgrade.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("products")
public class ProductController {
    @Autowired
    private IProductService service;

    @GetMapping("")
    public String showProductList(Model model) {
        List<Product> productList = service.findAll();
        model.addAttribute("products", productList);
        return "list";
    }

    @GetMapping("/create")
    public String addList(Model model) {
        model.addAttribute("products", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String add(Product products) {
        service.create(products);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editList(Model model, @PathVariable int id) {
        model.addAttribute("products", service.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Product products) {
        service.create(products);
        return "redirect:/products";
    }

    @GetMapping("/views/{id}")
    public String viewList(Model model, @PathVariable int id) {
        model.addAttribute("products", service.findById(id));
        return "view" ;
    }
    @GetMapping("/search")
    public String viewListName(Model model,@RequestParam String name) {
        List<Product> productList = service.findByName(name);
        model.addAttribute("products", productList);
        return "list";
    }
}
