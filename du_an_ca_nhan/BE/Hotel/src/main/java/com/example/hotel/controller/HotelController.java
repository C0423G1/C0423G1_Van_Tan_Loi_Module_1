package com.example.hotel.controller;

import com.example.hotel.dto.*;
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

    @PostMapping("/checktype")
    public ResponseEntity<String> getCheckRoomHotel(@RequestBody TypeRoomCheckDto request) {
        int checkIdUser = service.findByIdName(request.getNameUser());
        service.checkAddRoom(checkIdUser, request.getIdTypeHotel(), request.getStartDate(), request.getEndDate());
        return ResponseEntity.ok("Đã thêm order");
    }
    @PostMapping("/pay")
    public ResponseEntity<String> getPay(@RequestBody Pay request) {
        int checkIdUser = service.findByIdName(request.getUserName());
        service.pay(checkIdUser, request.getIdTypeHotel(), request.getStartDate(), request.getEndDate(),request.getFullName(),request.getPhoneNumber());
        return ResponseEntity.ok("Đã thêm thanh toán");
    }

    @PostMapping("/checkpay")
    public ResponseEntity<ArrayList<OrderBillDto>> getCheckPay(@RequestBody PayCheck request) {
        int checkIdUser = service.findByIdName(request.getNameUser());
        ArrayList<OrderBillDto> orderBill = service.checkPay(checkIdUser, request.getId(),request.getStartDate(), request.getEndDate());
        return ResponseEntity.ok(orderBill);
    }
    @PostMapping("/checkpayroom")
    public ResponseEntity<ArrayList<PayRoomDto>> getCheckPayRoom(@RequestBody PayCheck request) {
        int checkIdUser = service.findByIdName(request.getNameUser());
        ArrayList<PayRoomDto> orderBill = service.checkPayRoom(checkIdUser,request.getId(), request.getStartDate(), request.getEndDate());
        return ResponseEntity.ok(orderBill);
    }
    @PostMapping("/check-room")
    public ResponseEntity<Integer> getCheckPayRoom(@RequestBody RoomCheckDto request) {
        int checkIdUser = service.findByIdName(request.getUserName());
        Integer orderBill = service.checkRoom(request.getIdTypeHotel(),checkIdUser,request.getStartDate(), request.getEndDate());
        return ResponseEntity.ok(orderBill);
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

    @GetMapping("/applications/{id}")
    public ResponseEntity<ArrayList<ApplicationsDto>> getApplications(@PathVariable Long id) {
        ArrayList<ApplicationsDto> applications = service.findByIdApplications(id);
        if (applications != null) {
            return new ResponseEntity<>(applications, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/typeHotel")
    public ResponseEntity<ArrayList<TypeRoomDto>> getHotelById(@RequestBody RoomDto room ) {
        ArrayList<TypeRoomDto> typeRoom = service.findByIdTypeRoom(room.getId(),room.getEndDate(),room.getStartDate());
        if (typeRoom != null) {
            return new ResponseEntity<>(typeRoom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
