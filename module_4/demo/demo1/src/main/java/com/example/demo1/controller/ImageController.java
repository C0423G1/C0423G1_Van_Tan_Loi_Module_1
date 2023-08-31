package com.example.demo1.controller;

import com.example.demo1.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/vehicle")
public class ImageController {
    @Autowired
    ImageService service;

    @GetMapping("")
    public String uploadImages(){
        return "Tệp đã được tải lên thành công.";
    }
    @PostMapping("/upload")
    @ResponseBody
    public String uploadImages(@RequestParam("fileInput1") MultipartFile file1,
                               @RequestParam("fileInput2") MultipartFile file2,
                               @RequestParam("fileInput3") MultipartFile file3,
                               @RequestParam("fileInput4") MultipartFile file4) {
            service.save(String.valueOf(file1));
            service.save(String.valueOf(file2));
            service.save(String.valueOf(file3));
            service.save(String.valueOf(file4));
        return "Tệp đã được tải lên thành công.";
    }


}
