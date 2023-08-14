package com.example.homthu.controller;

import com.example.homthu.model.EmailConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class ConfigurationController {
    private EmailConfiguration emailConfiguration = new EmailConfiguration();

    @GetMapping("/config")
    public String getConfigForm(Model model) {
        model.addAttribute("config", emailConfiguration);
        return "form";
    }

    @PostMapping("/config/post")
    public String saveConfig(@RequestParam String language, @RequestParam int pagesize, @RequestParam String spamsfilter, @RequestParam String signature) {
        emailConfiguration.setLanguage(language);
        emailConfiguration.setPageSize(pagesize);
        emailConfiguration.setSignature(signature);
        emailConfiguration.setSpamsfilter(spamsfilter);
        return "redirect:/config";
    }
}
