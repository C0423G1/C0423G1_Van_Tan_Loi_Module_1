package com.example.demo1.service;

import com.example.demo1.repository.IImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService implements IImageService{
    @Autowired
    IImageRepository repository;
    @Override
    public void save(String file1) {
        repository.saveFile(file1);
    }
}
