package com.example.bookingtour.Service;

import com.example.bookingtour.Model.BookingDto;
import com.example.bookingtour.Model.Bookings;
import com.example.bookingtour.Repository.BookingRepository;
import com.example.bookingtour.Repository.IBookingRepository;

import java.sql.SQLException;
import java.util.List;

public class BookingService implements IBookingService{
    IBookingRepository repository = new BookingRepository();
    @Override
    public List<BookingDto> display() throws SQLException {
        return repository.display();
    }
}
