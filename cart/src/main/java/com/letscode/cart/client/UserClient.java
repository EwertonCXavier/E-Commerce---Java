package com.letscode.cart.client;

import com.letscode.cart.dto.UserDTO;
import com.letscode.cart.dto.UserItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="users", url = "http://localhost:8089/users")
public interface UserClient {

  @GetMapping("/id?email=teste@teste.com")
  UserItemDTO getUserById();


}
