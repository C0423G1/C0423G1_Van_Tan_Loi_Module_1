package com.example.bookingtour.Service;

import com.example.bookingtour.Model.BookingDto;
import com.example.bookingtour.Repository.BookingRepository;
import com.example.bookingtour.Repository.IBookingRepository;

import java.sql.SQLException;
import java.util.List;

public class BookingService implements IBookingService{
    IBookingRepository repository = new BookingRepository();
    @Override
    public List<BookingDto> display(int id) throws SQLException {
        return repository.display(id);
    }

    @Override
    public void addQuantity(int id, int idCustomer) throws SQLException {
        repository.addQuantity(id , idCustomer);
    }

    @Override
    public void deleteQuantity(int id, int idCustomer) throws SQLException {
        repository.deleteQuantity(id,idCustomer);
    }

    @Override
    public void deleteQuantityCart(int id, int idCustomer) throws SQLException {
        repository.deleteQuantityCart(id,idCustomer);
    }
}
