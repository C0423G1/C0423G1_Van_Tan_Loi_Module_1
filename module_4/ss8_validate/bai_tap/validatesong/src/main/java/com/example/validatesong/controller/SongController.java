package com.example.validatesong.controller;


import com.example.validatesong.model.Song;
import com.example.validatesong.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("song")
public class SongController {
    @Autowired
    ISongService service;
    @GetMapping("")
    public String showProductList(@RequestParam(defaultValue = "0",required = false)int page, Model model) {
        Pageable pageable = PageRequest.of(page,3);
        Page<Song> blogList = service.findAll(pageable);
        model.addAttribute("song", blogList);
        return "list";
    }
    @GetMapping("/create")
    public String addList(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }
    @PostMapping("/create")
    public String add(@Validated @ModelAttribute Song song,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            return "create";
        }
        service.create(song);
        redirectAttributes.addFlashAttribute("mess","Thêm Mới Thành Công");
        return "redirect:/song";
    }
    @GetMapping("/edit/{id}")
    public String editList(Model model,@PathVariable int id) {
        Song song = service.findById(id);
        model.addAttribute("song",song);
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute Song song,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            return "create";
        }
        service.create(song);
        redirectAttributes.addFlashAttribute("mess","Sửa Thông Tin Thành Công");
        return "redirect:/song";
    }
}
