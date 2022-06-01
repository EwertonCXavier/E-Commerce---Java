package com.letscode.user.service;

import com.letscode.user.client.UserProductClient;
import com.letscode.user.dto.ProductDTO;
import com.letscode.user.model.User;
import com.letscode.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

  private final UserRepository userRepository;


  @Override
  public User createUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public User getUserById(String userId) {
    Optional<User> optionalUser = userRepository.findById(userId);

    if(optionalUser.isPresent()) {
      return optionalUser.get();
    }

    throw new IllegalStateException("User not found!");
  }

  @Override
  public List<User> getAllUsers() {
    return (List<User>) userRepository.findAll();
  }


}
