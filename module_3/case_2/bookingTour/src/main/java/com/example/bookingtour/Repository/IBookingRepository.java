package com.example.bookingtour.Repository;

import com.example.bookingtour.Model.BookingDto;
import com.example.bookingtour.Model.Bookings;
import com.example.bookingtour.Model.Tours;

import java.sql.SQLException;
import java.util.List;

public interface IBookingRepository {
    List<BookingDto> display() throws SQLException;
}
