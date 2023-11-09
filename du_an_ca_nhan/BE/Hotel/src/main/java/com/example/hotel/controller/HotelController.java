package com.example.hotel.controller;

import com.example.hotel.dto.HotelDto;
import com.example.hotel.dto.HotelDtoList;
import com.example.hotel.model.hotel.ImageAvatar;
import com.example.hotel.model.hotel.TypeRoomHotel;
import com.example.hotel.service.hotel.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class HotelController {
    @Autowired
    private IHotelService service;

    @PostMapping("/list")
    public ResponseEntity<ArrayList<HotelDto>> getList(@RequestBody HotelDtoList request) {
        ArrayList<HotelDto> hotelDto = service.findSreach(request);
        return ResponseEntity.ok(hotelDto);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<HotelDto> getTypeHotelById(@PathVariable Long id) {
        HotelDto hotel = service.findById(id);
        if (hotel != null) {
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/imageHotel/{id}")
    public ResponseEntity<ArrayList<ImageAvatar>> getIamgeHotelById(@PathVariable Long id) {
        ArrayList<ImageAvatar> imageHotel = service.findByIdIamge(id);
        if (imageHotel != null) {
            return new ResponseEntity<>(imageHotel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/typeHotel/{id}")
    public ResponseEntity<ArrayList<TypeRoomHotel>> getHotelById(@PathVariable Long id) {
        ArrayList<TypeRoomHotel> typeRoom = service.findByIdTypeRoom(id);
        if (typeRoom != null) {
            return new ResponseEntity<>(typeRoom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
