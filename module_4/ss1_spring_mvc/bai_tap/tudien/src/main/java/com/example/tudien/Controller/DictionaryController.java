package com.example.tudien.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class DictionaryController {
    private static final String[] words = {
            "hello", "banana","one","two"
    };
    private static final String[] tiengviet ={
      "xin chào","quả chuối","một","hai"
    };
    @GetMapping("/dictionary")
    public ModelAndView showDictionary() {
        return new ModelAndView("dictionary");
    }

    @PostMapping("/dictionary/lookup")
    public ModelAndView lookupWord(@RequestParam String word) {
        ModelAndView modelAndView = new ModelAndView("dictionary");
        boolean found = false;
        String meaning = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(word)) {
                found = true;
                meaning = "dịch :" +  tiengviet[i] ;
                break;
            }
        }
        modelAndView.addObject("found", found);
        modelAndView.addObject("meaning", meaning);
        return modelAndView;
    }

}
