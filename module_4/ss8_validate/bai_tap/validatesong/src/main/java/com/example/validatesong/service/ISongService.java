package com.example.validatesong.service;


import com.example.validatesong.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {
    Page<Song> findAll(Pageable pageable);

    void create(Song song);


    Song findById(int id);
}
