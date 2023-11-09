package com.example.hotel.service.hotel;

import com.example.hotel.dto.HotelDto;
import com.example.hotel.dto.HotelDtoList;
import com.example.hotel.model.hotel.Hotel;
import com.example.hotel.model.hotel.ImageAvatar;
import com.example.hotel.model.hotel.TypeRoomHotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface IHotelService {
    Page<HotelDto> findAll(Pageable pageable, int numberOfGuests, String endDate, String startDate, String selectedLocation);

    ArrayList<HotelDto> findSreach(HotelDtoList request);

    HotelDto findById(Long id);

    ArrayList<TypeRoomHotel> findByIdTypeRoom(Long id);

    ArrayList<ImageAvatar> findByIdIamge(Long id);
}
