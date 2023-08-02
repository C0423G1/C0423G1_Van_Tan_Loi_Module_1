package com.example.user.Repository;

import com.example.user.Model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    @Override
    public List<Users> list() throws SQLException {
        Connection connection = BaseRepository.getConnection();
        List<Users> arraylist = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("call sp_get_users()");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String country = resultSet.getString("country");
            arraylist.add(new Users(id, name, email, country));
        }
        return arraylist;
    }

    @Override
    public Users findById(int id) throws SQLException {
        Connection connection = BaseRepository.getConnection();
        List<Users> arraylist = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select *from users");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int index = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String country = resultSet.getString("country");
            arraylist.add(new Users(index, name, email, country));
        }
        Users user = null;
        for (int i = 0; i < arraylist.size(); i++) {
            if (id == arraylist.get(i).getId()) {
                user = arraylist.get(i);
            }
        }
        return user;
    }

    @Override
    public void edit(Users users) throws SQLException {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("call sp_update_user(?,?,?,?)");
        preparedStatement.setInt(1, users.getId());
        preparedStatement.setString(2, users.getName());
        preparedStatement.setString(3, users.getEmail());
        preparedStatement.setString(4, users.getCountry());
        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("call sp_delete_user(?)");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public void add(Users users) throws SQLException {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into users values (?,?,?,?);");
        preparedStatement.setInt(1, users.getId());
        preparedStatement.setString(2, users.getName());
        preparedStatement.setString(3, users.getEmail());
        preparedStatement.setString(4, users.getCountry());
        preparedStatement.executeUpdate();
    }

    @Override
    public List<Users> arrange() throws SQLException {
        Connection connection = BaseRepository.getConnection();
        List<Users> arraylist = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users ORDER BY name;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String country = resultSet.getString("country");
            arraylist.add(new Users(id, name, email, country));
        }
        return arraylist;
    }

    @Override
    public ArrayList<Users> search(String country) throws SQLException {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("");
        preparedStatement.setString(1, country);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Users> arraylist = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String countrys = resultSet.getString("country");
            arraylist.add(new Users(id, name, email, countrys));
        }
        return arraylist;
    }

}
