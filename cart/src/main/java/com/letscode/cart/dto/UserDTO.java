package com.letscode.cart.dto;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class UserDTO {
  private String userId;
  private String email;
  private String senha;
}
