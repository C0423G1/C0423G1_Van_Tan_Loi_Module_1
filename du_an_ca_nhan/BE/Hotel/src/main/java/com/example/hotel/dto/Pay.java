package com.example.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Pay {
    String fullName;
    String phoneNumber;
    int idTypeHotel;
    String startDate;
    String endDate;
    String userName;
}
