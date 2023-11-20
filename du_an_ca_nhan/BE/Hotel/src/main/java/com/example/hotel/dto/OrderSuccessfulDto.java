package com.example.hotel.dto;

public interface OrderSuccessfulDto {
    int getIdOrder();
    String getDateStart();
    String getDateEnd();
    int getQuantity();
    int getSumPrice();
    String getNameTypeHotel();
    int getQuantityBed();
    int getQuantityRoom();
    String getNameHotel();
    String getUrlImage();
}
