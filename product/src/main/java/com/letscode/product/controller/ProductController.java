package com.letscode.product.controller;

import com.letscode.product.model.Product;
import com.letscode.product.service.ProductServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

  private final ProductServiceImp productServiceImp;

  @PostMapping
  public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    return ResponseEntity.ok().body(productServiceImp.createProduct(product));
  }

  @GetMapping
  public ResponseEntity<List<Product>> getAllProducts() {
    return ResponseEntity.ok(productServiceImp.getAllProducts());
  }

  @GetMapping("/{productId}")
  public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
    return ResponseEntity.ok().body(productServiceImp.getProductById(productId));
  }
}
