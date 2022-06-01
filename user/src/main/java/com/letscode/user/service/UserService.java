package com.letscode.user.service;

import com.letscode.user.dto.ProductDTO;
import com.letscode.user.model.User;

import java.util.List;

public interface UserService {
  User createUser(User user);
  User getUserById(String userId);
  List<User> getAllUsers();

}
