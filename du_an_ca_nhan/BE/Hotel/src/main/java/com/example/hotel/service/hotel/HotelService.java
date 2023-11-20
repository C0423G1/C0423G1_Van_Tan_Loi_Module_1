package com.example.hotel.service.hotel;

import com.example.hotel.dto.*;
import com.example.hotel.model.hotel.ApplicationsHotel;
import com.example.hotel.model.hotel.ImageAvatar;
import com.example.hotel.model.hotel.TypeRoomHotel;
import com.example.hotel.model.order.OrderBill;
import com.example.hotel.model.user.customer.Customer;
import com.example.hotel.repository.hotel.ICustomerRepository;
import com.example.hotel.repository.hotel.IHotelRepository;
import com.example.hotel.repository.hotel.IImageRepository;
import com.example.hotel.repository.hotel.ITypeRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService implements IHotelService {
    @Autowired
    private IHotelRepository repository;
    @Autowired
    private IImageRepository imageRepository;
    @Autowired
    private ITypeRoomRepository typeRoomRepository;
    @Autowired
    private ICustomerRepository customerRepository;

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
    public ArrayList<TypeRoomDto> findByIdTypeRoom(int id, String endDate, String startDate) {
        return typeRoomRepository.findAllByIdTypeRoom(id, endDate, startDate);
    }

    @Override
    public ArrayList<PayRoomDto> checkPayRoom(int checkIdUser, int id, String startDate, String endDate) {
        return typeRoomRepository.getRoomPay(checkIdUser, id, startDate, endDate);
    }

    @Override
    public void pay(int checkIdUser, int idTypeHotel, String startDate, String endDate, String fullName, String phoneNumber) {
        typeRoomRepository.pay(checkIdUser, idTypeHotel, startDate, endDate, fullName, phoneNumber);
    }

    @Override
    public Integer checkRoom(int typeHotel, int id, String startDate, String endDate) {
        Integer paid = typeRoomRepository.checkRoom(typeHotel, startDate, endDate);
        Integer unpaid = typeRoomRepository.checkRoomUnpaid(typeHotel, id, startDate, endDate);
        if (unpaid == null) {
            unpaid = 0;
        }
        return paid - unpaid;
    }

    @Override
    public int FindByUserName(int checkIdUser) {
        return imageRepository.findByNameUser(checkIdUser);
    }

    @Override
    public Customer checkCustomer(int checkIdCustomer) {
        return customerRepository.findById(checkIdCustomer).orElse(null);
    }

    @Override
    public ArrayList<OrderSuccessfulDto> orderSuccess(int checkIdUser) {
        return repository.checkOrderSuccess(checkIdUser);
    }

    @Override
    public ArrayList<ImageAvatar> findByIdIamge(Long id) {
        return imageRepository.findByIdIamge(id);
    }

    @Override
    public ArrayList<ApplicationsDto> findByIdApplications(Long id) {
        return repository.findByIdApplications(id);
    }

    @Override
    public int findByIdName(String nameUser) {
        return repository.findByNameUser(nameUser);
    }

    @Override
    public void checkAddRoom(int checkIdUser, int idTypeHotel, String startDate, String endDate) {
        ArrayList<OrderBillDto> check = repository.checkAddRoomm(checkIdUser, idTypeHotel, startDate, endDate);
        if (check == null || check.isEmpty()) {
            repository.addRoom(checkIdUser, idTypeHotel, startDate, endDate);
        } else {
            repository.addQuanityTypeRoom(checkIdUser, idTypeHotel, startDate, endDate);
        }
    }

    @Override
    public ArrayList<OrderBillDto> checkPay(int checkIdUser, int id, String startDate, String endDate) {
        return repository.checkPay(checkIdUser, id, startDate, endDate);
    }
}
