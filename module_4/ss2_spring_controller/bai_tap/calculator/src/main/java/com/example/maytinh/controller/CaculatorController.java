package com.example.maytinh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class CaculatorController {
    @GetMapping("/caculator")
    public String showCalculatorForm() {
        return "list";
    }

    @PostMapping("/caculator/calculate")
    public String calculate(@RequestParam double num1,
                            @RequestParam double num2,
                            @RequestParam String operator,
                            Model model) {
        double result;
        switch (operator) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                result = num1 / num2;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("result", result);
        return "list";
    }
}
