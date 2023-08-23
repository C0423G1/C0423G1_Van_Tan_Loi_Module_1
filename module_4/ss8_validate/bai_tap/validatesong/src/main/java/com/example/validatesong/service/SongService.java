package com.example.validatesong.service;


import com.example.validatesong.model.Song;
import com.example.validatesong.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService {
    @Autowired
    ISongRepository repository;

    @Override
    public Page<Song> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void create(Song song) {
        repository.save(song);
    }

    @Override
    public Song findById(int id) {
        return repository.findById(id).get();
    }
}
