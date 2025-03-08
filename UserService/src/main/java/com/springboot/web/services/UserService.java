package com.springboot.web.services;

import java.util.List;
import java.util.Optional;

import com.springboot.web.entities.User;

public interface UserService {
public User saveUser(User user);
public List<User> getAllUsers();
public User getUserById(String id);
public User updateUserById(String id,User user);
}
