package com.letscode.product.service;

import com.letscode.product.model.Product;

import java.util.List;

public interface ProductService {
  Product createProduct(Product product);
  List<Product> getAllProducts();
  Product getProductById(Long productId);

}
