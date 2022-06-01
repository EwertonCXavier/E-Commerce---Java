package com.letscode.user.dto;

import lombok.Data;

@Data
public class ProductDTO {
  private Long productId;
  private String nomeProduto;
  private Long quantidade;
  private Double valorUnit;
}
