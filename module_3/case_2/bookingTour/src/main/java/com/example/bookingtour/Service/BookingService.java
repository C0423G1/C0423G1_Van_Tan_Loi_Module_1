package com.example.bookingtour.Service;

import com.example.bookingtour.Model.BookingDto;
import com.example.bookingtour.Model.FromDto;
import com.example.bookingtour.Model.RoleDto;
import com.example.bookingtour.Model.TourEmailDto;
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

    @Override
    public void success(int customerId) throws SQLException {
        repository.success(customerId);
    }

    @Override
    public List<RoleDto> displayRole() throws SQLException {
        return repository.displayRole();
    }

    @Override
    public List<RoleDto> displaySuccess() throws SQLException {
        return repository.displaySuccess();
    }

    @Override
    public List<RoleDto> displayFailure(String startDate, String endDate) throws SQLException {
        return repository.displayFailure(startDate,endDate);
    }

    @Override
    public List<RoleDto> displayChart(int month, int year) throws SQLException {
        return repository.displayChart( month,  year);
    }

    @Override
    public List<TourEmailDto> displayEmail(int customerId) throws SQLException {
         return repository.displayEmail(customerId);

    }

    @Override
    public void quantityList(int id) throws SQLException {
        repository.quantityList(id);
    }

    @Override
    public int checkQuantity(int id, int customerId, int quantity) throws SQLException {
        return repository.checkQuantity(id,customerId,quantity);
    }

    @Override
    public FromDto displayFrom(int customerId) throws SQLException {
        return repository.displayFrom(customerId);
    }
}
