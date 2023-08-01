package com.example.users.Service;

import com.example.users.Model.Users;
import com.example.users.Repository.IUserRepository;
import com.example.users.Repository.UserRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService{
    IUserRepository repository = new UserRepository();

    @Override
    public List<Users> display() throws SQLException {
        return repository.list();
    }

    @Override
    public Users findById(int id) throws SQLException {
        return repository.findById(id);
    }

    @Override
    public void edit(Users users) throws SQLException {
        repository.edit(users);
    }

    @Override
    public void delete(int id) throws SQLException {
        repository.delete(id);
    }

    @Override
    public void add(Users users) throws SQLException {
        repository.add(users);
    }

    @Override
    public List<Users> arrange() throws SQLException {
        return repository.arrange();
    }

    @Override
    public ArrayList<Users> search(String country) throws SQLException {
        return repository.search(country);
    }
}
