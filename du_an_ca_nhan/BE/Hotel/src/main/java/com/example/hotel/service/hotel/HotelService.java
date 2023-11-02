package com.example.hotel.service.hotel;

import com.example.hotel.dto.HotelDto;
import com.example.hotel.model.hotel.Hotel;
import com.example.hotel.repository.hotel.IHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HotelService implements IHotelService {
    @Autowired
    private IHotelRepository repository;
    @Override
    public Page<HotelDto> findAll(Pageable pageable, int numberOfGuests, String endDate, String startDate, String selectedLocation) {
//        return repository.findAllSreach(pageable,numberOfGuests,endDate,startDate,selectedLocation);
    return null;
    }
}
