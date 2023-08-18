package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService service;

    @GetMapping("/products")
    public String showProductList(Model model) {
        List<Product> productList = service.findAll();
        model.addAttribute("products", productList);
        return "list";
    }

    @GetMapping("/products/create")
    public String addList(Model model) {
        model.addAttribute("products", new Product());
        return "create";
    }

    @PostMapping("/products/create")
    public String add(Product products) {
        service.create(products);
        return "redirect:/products";
    }

    @GetMapping("/products/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String editList(Model model, @PathVariable int id) {
        model.addAttribute("products", service.findById(id));
        return "edit";
    }

    @PostMapping("/products/edit")
    public String edit(Product products) {
        service.create(products);
        return "redirect:/products";
    }

    @GetMapping("/products/views/{id}")
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
