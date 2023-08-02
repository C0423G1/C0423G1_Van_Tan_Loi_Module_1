package com.example.bookingtour.Repository;

import com.example.bookingtour.Model.BookingDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository implements IBookingRepository {
    public static final String DISPLAY = "call list_booking(?);";
    public static final String ADDQUANTITY = "UPDATE bookings SET quantity = quantity + 1 WHERE tour_id = ? AND customer_id =?;";
    public static final String DELETEQUANTITY = "UPDATE bookings SET quantity = quantity - 1 WHERE tour_id = ? AND customer_id =?;";
    public static final String DELETEQUANTITYCART = "UPDATE bookings SET quantity = 0 WHERE tour_id = ? AND customer_id =?;";
    public static final String DISPLAYQUANTITY = "select * from bookings WHERE tour_id = ? AND customer_id =?; ";
    public static final String INSERTQUANTITY = "INSERT INTO bookings (booking_date, quantity, price, is_delete, customer_id, tour_id, status) SELECT CURDATE(), 1, tours.tour_price, 0, ?, ?, 0 FROM tours WHERE tours.tour_id = ?;";

    @Override
    public List<BookingDto> display(int id) throws SQLException {
        Connection connection = BaseRepository.getConnection();
        ArrayList<BookingDto> arraylist = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(DISPLAY);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int customerId = resultSet.getInt("customer_id");
            String tourName = resultSet.getString("tour_name");
            double tourPrice = resultSet.getDouble("tour_price");
            int quantity = resultSet.getInt("quantity");
            double tourSumPrice = resultSet.getDouble("total_price");
            int status = resultSet.getInt("status");
            int tourId =resultSet.getInt("tour_id");
            arraylist.add(new BookingDto(customerId, tourName, tourPrice, quantity, tourSumPrice, status,tourId));
        }
        return arraylist;

    }

    @Override
    public void addQuantity(int id, int idCustomer) throws SQLException {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DISPLAYQUANTITY);
        preparedStatement.setInt(1, id);
        preparedStatement.setInt(2, idCustomer);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (!resultSet.next()) {
            Connection connection2 = BaseRepository.getConnection();
            PreparedStatement preparedStatement2 = connection2.prepareStatement(INSERTQUANTITY);
            preparedStatement2.setInt(1, idCustomer);
            preparedStatement2.setInt(2, id);
            preparedStatement2.setInt(3, id);

            preparedStatement2.executeUpdate(); // Thực hiện INSERT, không cần lưu ResultSet

            preparedStatement2.close(); // Đóng PreparedStatement khi đã sử dụng xong
            connection2.close(); // Đóng kết nối khi đã sử dụng xong
        } else {
            // ResultSet không cần sử dụng nữa, đóng nó lại
            resultSet.close();

            Connection connection1 = BaseRepository.getConnection();
            PreparedStatement preparedStatement1 = connection1.prepareStatement(ADDQUANTITY);
            preparedStatement1.setInt(1, id);
            preparedStatement1.setInt(2, idCustomer);
            preparedStatement1.executeUpdate(); // Thực hiện UPDATE, không cần lưu ResultSet

            preparedStatement1.close(); // Đóng PreparedStatement khi đã sử dụng xong
            connection1.close(); // Đóng kết nối khi đã sử dụng xong
        }

        preparedStatement.close(); // Đóng PreparedStatement khi đã sử dụng xong
        connection.close(); // Đóng kết nối khi đã sử dụng xong
    }

    @Override
    public void deleteQuantity(int id, int idCustomer) throws SQLException {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETEQUANTITY);
        preparedStatement.setInt(1, id);
        preparedStatement.setInt(2, idCustomer);
        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteQuantityCart(int id, int idCustomer) throws SQLException {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETEQUANTITYCART);
        preparedStatement.setInt(1, id);
        preparedStatement.setInt(2, idCustomer);
        preparedStatement.executeUpdate();
    }

}
