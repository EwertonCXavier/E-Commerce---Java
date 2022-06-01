package com.letscode.cart.dto;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class ProductDTO {
  private Long productId;
  private String nomeProduto;
  private Long quantidade;
  private Double valorUnit;
}
