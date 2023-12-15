package com.example.hotel.service.hotel;

import com.example.hotel.dto.*;
import com.example.hotel.model.hotel.ImageAvatar;
import com.example.hotel.model.hotel.TypeRoomHotel;
import com.example.hotel.model.user.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface IHotelService {

    Page<HotelDto> findAll(Pageable pageable, int numberOfGuests, String endDate, String startDate, String selectedLocation);

    ArrayList<HotelDto> findSreach(HotelDtoList request);

    HotelDto findById(Long id);


    ArrayList<ImageAvatar> findByIdIamge(Long id);

    ArrayList<ApplicationsDto> findByIdApplications(Long id);

    int findByIdName(String nameUser);

    void checkAddRoom(int checkIdUser, int idTypeHotel, String startDate, String endDate);

    ArrayList<OrderBillDto> checkPay(int checkIdUser, int id,String startDate, String endDate);

    ArrayList<TypeRoomDto> findByIdTypeRoom(int id, String endDate, String startDate);

    ArrayList<PayRoomDto> checkPayRoom(int checkIdUser, int id, String startDate, String endDate);

    void pay(int checkIdUser, int idTypeHotel, String startDate, String endDate, String fullName, String phoneNumber);

    Integer checkRoom(int typeHotel, int id ,String startDate, String endDate);

    int FindByUserName(int checkIdUser);

    Customer checkCustomer(int checkIdCustomer);

    ArrayList<OrderSuccessfulDto> orderSuccess(int checkIdUser);

}
