package com.example.hotel.service.hotel;

import com.example.hotel.dto.HotelDto;
import com.example.hotel.model.hotel.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IHotelService {
    Page<HotelDto> findAll(Pageable pageable, int numberOfGuests, String endDate, String startDate, String selectedLocation);
}
