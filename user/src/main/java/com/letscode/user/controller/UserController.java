package com.letscode.user.controller;

import com.letscode.user.client.UserProductClient;
import com.letscode.user.dto.ProductDTO;
import com.letscode.user.model.User;
import com.letscode.user.service.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
  private final UserServiceImp userServiceImp;

  @Autowired
  private UserProductClient userProductClient;

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user) {
    return ResponseEntity.ok().body(userServiceImp.createUser(user));
  }

  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    return ResponseEntity.ok().body(userServiceImp.getAllUsers());
  }


  @GetMapping("/{userId}")
  public ResponseEntity<User> getUserById(@PathVariable String userId) {
    return ResponseEntity.ok().body(userServiceImp.getUserById(userId));
  }






}
