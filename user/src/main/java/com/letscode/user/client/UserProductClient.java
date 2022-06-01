package com.letscode.user.client;

import com.letscode.user.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product")
public interface UserProductClient {
  @GetMapping("/product")
  List<ProductDTO> getAllProducts();

  @GetMapping("/product/{productId}")
  ProductDTO getProductById(@PathVariable("productId") Long productId);
}
