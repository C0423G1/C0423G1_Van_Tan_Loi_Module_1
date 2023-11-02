package com.example.hotel.config.sercurity;


import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;

import java.util.Iterator;

public class CustomerUserDetails implements User {
    @Override
    public String getFullName() {
        return null;
    }

    @Override
    public void setFullName(String fullName) {

    }

    @Override
    public Iterator<Group> getGroups() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public Iterator<Role> getRoles() {
        return null;
    }

    @Override
    public UserDatabase getUserDatabase() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public void setUsername(String username) {

    }

    @Override
    public void addGroup(Group group) {

    }

    @Override
    public void addRole(Role role) {

    }

    @Override
    public boolean isInGroup(Group group) {
        return false;
    }

    @Override
    public boolean isInRole(Role role) {
        return false;
    }

    @Override
    public void removeGroup(Group group) {

    }

    @Override
    public void removeGroups() {

    }

    @Override
    public void removeRole(Role role) {

    }

    @Override
    public void removeRoles() {

    }

    @Override
    public String getName() {
        return null;
    }
}
