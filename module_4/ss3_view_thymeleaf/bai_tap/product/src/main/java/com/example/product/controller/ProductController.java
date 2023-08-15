package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    @GetMapping("/products/create")
    public String addList(){
        return "create";
    }
    @PostMapping("/products/create")
    public String add(Product product){
        service.create(product);
        return "redirect:/products";
    }
}
