package com.example.tiente.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyConverterController {
    @GetMapping("/converts")
    public ModelAndView showConverter() {
        return new ModelAndView("converter");
    }

    @PostMapping("/converts/convert")
    public ModelAndView convertCurrency(@RequestParam double exchangeRate, @RequestParam double usdAmount) {
        double vndAmount = usdAmount * exchangeRate;
        ModelAndView modelAndView = new ModelAndView("converter");
        modelAndView.addObject("vndAmount", vndAmount);
        return modelAndView;
    }

}
