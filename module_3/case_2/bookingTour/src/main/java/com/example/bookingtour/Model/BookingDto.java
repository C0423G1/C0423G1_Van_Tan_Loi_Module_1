package com.example.bookingtour.Model;

public class BookingDto {

    private String tourName;
    private String customerName;
    private String tourPrice;
    private int  quantity;
    public BookingDto() {
    }

    public BookingDto(String tourName, String customerName, String tourPrice, int quantity) {
        this.tourName = tourName;
        this.customerName = customerName;
        this.tourPrice = tourPrice;
        this.quantity = quantity;
    }


    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTourPrice() {
        return tourPrice;
    }

    public void setTourPrice(String tourPrice) {
        this.tourPrice = tourPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
