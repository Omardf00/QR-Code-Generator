package com.omar.qr.data.service;

import com.omar.qr.data.entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findById(int id);

    public User findByName(String name);

}
