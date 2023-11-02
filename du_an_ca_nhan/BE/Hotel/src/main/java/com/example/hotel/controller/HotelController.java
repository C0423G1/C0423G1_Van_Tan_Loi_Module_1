package com.example.hotel.controller;

import com.example.hotel.dto.HotelDto;
import com.example.hotel.model.hotel.Hotel;
import com.example.hotel.service.hotel.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/list")
public class HotelController {
    @Autowired
    private IHotelService service;
    @GetMapping("")
    public ResponseEntity<Page<HotelDto>> showCustomerList(
            @RequestParam("pageSize") int pageSize,
            @RequestParam("currentPage") int currentPage,
            @RequestParam("numberOfGuests") int numberOfGuests,
            @RequestParam("endDate") String endDate,
            @RequestParam("startDate") String startDate,
            @RequestParam("selectedLocation") String selectedLocation) {
        Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        Page<HotelDto> hotel = service.findAll(pageable, numberOfGuests, endDate, startDate, selectedLocation);
        if (hotel.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }
}
