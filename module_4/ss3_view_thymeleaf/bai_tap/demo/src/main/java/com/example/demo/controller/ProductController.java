package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService service ;
    @GetMapping("/products")
    public String showProductList(Model model) {
        List<Product> productList = service.findAll();
        model.addAttribute("products", productList);
        return "list";
    }
}
