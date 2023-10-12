package com.example.case_study_5_data.controller;

import com.example.case_study_5_data.module.*;
import com.example.case_study_5_data.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import com.google.zxing.*;
import com.google.zxing.qrcode.*;
import com.google.zxing.common.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.Base64;

import org.json.JSONObject;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private ICustomerService service;
    @Autowired
    private IContractService contractService;
    @Autowired
    private IVillaService villaService;

    @Autowired
    private IHouseService houseService;
    @Autowired
    private IRoomService roomService;

    //----------------------------------------------------- CUSTOMER ---------------------------------------------------
    @GetMapping("/customer")
    public ResponseEntity<Page<Customer>> showCustomerList(
            @RequestParam(name = "_page", defaultValue = "1") int page,
            @RequestParam(name = "_limit", defaultValue = "10") int pageSize,
            @RequestParam(name = "like_full_name", defaultValue = "") String fullName,
            @RequestParam(name = "like_customer_type", defaultValue = "") String customerType) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Customer> customers = service.findAll(pageable, fullName, customerType);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
        service.deleteCustomer(id);
        return ResponseEntity.ok("Customer with ID " + id + " has been deleted.");
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> showProduct(@PathVariable int id) {
        Customer customer = service.findAllById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable int id, @RequestBody Customer customerData) {
        service.editCustomer(id, customerData);
        return ResponseEntity.ok("Customer with ID " + id + " has been updated.");
    }

    @PostMapping("/customer")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customerData) throws WriterException, IOException {
        service.createCustomer(customerData);

        String qrCodeText = customerData.getSomeData();
        int width = 300;
        int height = 300;

        BitMatrix bitMatrix = new QRCodeWriter().encode(qrCodeText, BarcodeFormat.QR_CODE, width, height);
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        File qrCodeFile = new File("C:\\CodeGym-04\\ảnh\\qrcode" + customerData.getId() + ".png");
        ImageIO.write(bufferedImage, "png", qrCodeFile);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
        byte[] qrCodeImage = byteArrayOutputStream.toByteArray();
        String qrCodeBase64 = Base64.getEncoder().encodeToString(qrCodeImage);

        JSONObject response = new JSONObject();
        response.put("objectId", customerData.getId());
        response.put("qrCodeBase64", qrCodeBase64);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(response.toString(), HttpStatus.OK);
    }


    //    -----------------------------------------CONTRACT------------------------------------------
    @GetMapping("/contract")
    public ResponseEntity<Page<Contract>> showContractList(
            @RequestParam(name = "_page", defaultValue = "1") int page,
            @RequestParam(name = "_limit", defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Contract> contract = contractService.findAll(pageable);
        if (contract.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }


    @DeleteMapping("/contract/{id}")
    public ResponseEntity<String> deleteContract(@PathVariable int id) {
        contractService.deleteContract(id);
        return ResponseEntity.ok("Customer with ID " + id + " has been deleted.");
    }

    @GetMapping("/contract/{id}")
    public ResponseEntity<Contract> showContract(@PathVariable int id) {
        Contract contract = contractService.findAllById(id);
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

    @PutMapping("/contract/{id}")
    public ResponseEntity<String> updateContract(@PathVariable int id, @RequestBody Contract contract) {
        contractService.editContract(id, contract);
        return ResponseEntity.ok("Customer with ID " + id + " has been updated.");
    }

    @PostMapping("/contract")
    public ResponseEntity<String> createContract(@RequestBody Contract contract) {
        contractService.createContract(contract);
        return ResponseEntity.ok("Customer with ID " + " has been updated.");
    }

    //    --------------------------------------- VILLA --------------------------------------------------------------
    @GetMapping("/villa")
    public ResponseEntity<Page<Villa>> showVillaList(
            @RequestParam(name = "_page", defaultValue = "1") int page,
            @RequestParam(name = "_limit", defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Villa> villa = villaService.findAll(pageable);
        if (villa.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(villa, HttpStatus.OK);
    }


    @DeleteMapping("/villa/{id}")
    public ResponseEntity<String> deleteVilla(@PathVariable int id) {
        villaService.deleteVilla(id);
        return ResponseEntity.ok("Customer with ID " + id + " has been deleted.");
    }

    @GetMapping("/villa/{id}")
    public ResponseEntity<Villa> showVilla(@PathVariable int id) {
        Villa villa = villaService.findAllById(id);
        return new ResponseEntity<>(villa, HttpStatus.OK);
    }

    @PutMapping("/villa/{id}")
    public ResponseEntity<String> updateVilla(@PathVariable int id, @RequestBody Villa villa) {
        villaService.editVilla(id, villa);
        return ResponseEntity.ok("Customer with ID " + id + " has been updated.");
    }

    @PostMapping("/villa")
    public ResponseEntity<String> createVilla(@RequestBody Villa villa) {
        villaService.createVilla(villa);
        return ResponseEntity.ok("Customer with ID " + " has been updated.");
    }

    //    ---------------------------------------- HOUSE ----------------------------------------------------
    @GetMapping("/house")
    public ResponseEntity<Page<House>> showHouseList(
            @RequestParam(name = "_page", defaultValue = "1") int page,
            @RequestParam(name = "_limit", defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<House> houses = houseService.findAll(pageable);
        if (houses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }


    @DeleteMapping("/house/{id}")
    public ResponseEntity<String> deleteHouse(@PathVariable int id) {
        houseService.deleteHouse(id);
        return ResponseEntity.ok("Customer with ID " + id + " has been deleted.");
    }

    @GetMapping("/house/{id}")
    public ResponseEntity<House> showHouse(@PathVariable int id) {
        House house = houseService.findAllById(id);
        return new ResponseEntity<>(house, HttpStatus.OK);
    }

    @PutMapping("/house/{id}")
    public ResponseEntity<String> updateHouse(@PathVariable int id, @RequestBody House house) {
        houseService.editHouse(id, house);
        return ResponseEntity.ok("Customer with ID " + id + " has been updated.");
    }

    @PostMapping("/house")
    public ResponseEntity<String> createHouse(@RequestBody House house) {
        houseService.createHouse(house);
        return ResponseEntity.ok("Customer with ID " + " has been updated.");
    }

    //   ------------------------------------------------------ ROOM ----------------------------------------
    @GetMapping("/room")
    public ResponseEntity<Page<Room>> showRoomList(
            @RequestParam(name = "_page", defaultValue = "1") int page,
            @RequestParam(name = "_limit", defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Room> rooms = roomService.findAll(pageable);
        if (rooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }


    @DeleteMapping("/room/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable int id) {
        roomService.deleteRoom(id);
        return ResponseEntity.ok("Customer with ID " + id + " has been deleted.");
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<Room> showRoom(@PathVariable int id) {
        Room room = roomService.findAllById(id);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @PutMapping("/room/{id}")
    public ResponseEntity<String> updateRoom(@PathVariable int id, @RequestBody Room room) {
        roomService.editRoom(id, room);
        return ResponseEntity.ok("Customer with ID " + id + " has been updated.");
    }

    @PostMapping("/room")
    public ResponseEntity<String> createRoom(@RequestBody Room room) {
        roomService.createRoom(room);
        return ResponseEntity.ok("Customer with ID " + " has been updated.");
    }
}
