package com.example.homthu.controller;

import com.example.homthu.model.EmailConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConfigurationController {
    private EmailConfiguration emailConfiguration = new EmailConfiguration();

    @GetMapping("/config")
    public String getConfigForm(Model model) {
        model.addAttribute("config", emailConfiguration);
        return "form";
    }

    @PostMapping("/config/post")
    public String saveConfig(@ModelAttribute EmailConfiguration config) {
        emailConfiguration = config;
        return "redirect:/config";
    }
}
