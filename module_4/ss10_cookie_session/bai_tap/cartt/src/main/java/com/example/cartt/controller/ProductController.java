package com.example.cartt.controller;

import com.example.cartt.model.Cartt;
import com.example.cartt.model.Product;
import com.example.cartt.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    IProductService service;
    @GetMapping("")
    public String showProductList(Model model) {
        List<Product> productList = service.list();
        model.addAttribute("product",productList);
        return "product";
    }
}
