package com.example.giavi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class SandwichController {
    private static final List<String> condiments = Arrays.asList("Lettuce", "Tomato", "Onion", "Mayonnaise");

    @GetMapping("/sandwich")
    public ModelAndView showSandwichForm() {
        ModelAndView modelAndView = new ModelAndView("sandwich");
        modelAndView.addObject("condiments", condiments);
        return modelAndView;
    }

    @PostMapping("/sandwich/order")
    public ModelAndView orderSandwich(@RequestParam(value = "selectedCondiments", required = false) List<String> selectedCondiments) {
        ModelAndView modelAndView = new ModelAndView("sandwich");
        modelAndView.addObject("condiments", condiments);
        if (selectedCondiments != null) {
            modelAndView.addObject("selectedCondiments", selectedCondiments);
        }
        return modelAndView;
    }
}
