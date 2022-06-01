package com.letscode.cart.dto;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class CartItemDTO {
  private Long productId;
  private Long quantity;
}
