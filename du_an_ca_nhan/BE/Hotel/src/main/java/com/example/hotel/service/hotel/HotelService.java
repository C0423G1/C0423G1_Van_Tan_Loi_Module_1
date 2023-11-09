package com.example.hotel.service.hotel;

import com.example.hotel.dto.HotelDto;
import com.example.hotel.dto.HotelDtoList;
import com.example.hotel.model.hotel.ImageAvatar;
import com.example.hotel.model.hotel.TypeRoomHotel;
import com.example.hotel.repository.hotel.IHotelRepository;
import com.example.hotel.repository.hotel.IImageRepository;
import com.example.hotel.repository.hotel.ITypeRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HotelService implements IHotelService {
    @Autowired
    private IHotelRepository repository;
    @Autowired
    private IImageRepository imageRepository;
    @Autowired
    private ITypeRoomRepository typeRoomRepository;

    @Override
    public Page<HotelDto> findAll(Pageable pageable, int numberOfGuests, String endDate, String startDate, String selectedLocation) {
//        return repository.findAllSreach(pageable,numberOfGuests,endDate,startDate,selectedLocation);
        return null;
    }

    @Override
    public ArrayList<HotelDto> findSreach(HotelDtoList request) {
        return repository.findSreach(request.getSelectedLocation(), request.getStartDate(), request.getEndDate(), request.getNumberOfGuests());
//    return null;
    }

    @Override
    public HotelDto findById(Long id) {
        return repository.findByIdHotel(id);
    }

    @Override
    public ArrayList<TypeRoomHotel> findByIdTypeRoom(Long id) {
        return typeRoomRepository.findAllByIdTypeRoom(id);
    }

    @Override
    public ArrayList<ImageAvatar> findByIdIamge(Long id) {
        return imageRepository.findByIdIamge(id);
    }
}
