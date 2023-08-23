package com.example.validatesong.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Pattern(regexp = "^[a-zA-Z0-9\\s!&$#()%']{1,800}$",message = "Tên Bài Hát không hợp lệ ")
    private String nameSong;

    @Pattern(regexp = "^[a-zA-Z0-9\\s!&$#()%']{1,300}$",message = "Tên nghệ sĩ không hợp lệ ")
    private String artist ;

    @Pattern(regexp = "^[a-zA-Z0-9\\s,!&$#()%']{1,1000}$",message = "Tên thể loại không hợp lệ ")
    private String category;


    public Song(int id, String nameSong, String artist, String category) {
        this.id = id;
        this.nameSong = nameSong;
        this.artist = artist;
        this.category = category;
    }

    public Song() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
