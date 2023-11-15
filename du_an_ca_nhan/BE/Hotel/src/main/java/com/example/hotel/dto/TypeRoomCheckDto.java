package com.example.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TypeRoomCheckDto {
    int idTypeHotel;
    String nameUser;
    String startDate;
    String endDate;
}
