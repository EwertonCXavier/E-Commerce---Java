package com.letscode.cart.client;

import com.letscode.cart.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user")
public interface UserClient {

  @GetMapping("/user/{userId}")
  UserDTO getUserById(@PathVariable("userId") String userId);


}
