package com.letscode.product.service;

import com.letscode.product.model.Product;
import com.letscode.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public Product createProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public List<Product> getAllProducts() {
    return (List<Product>) productRepository.findAll();
  }

  @Override
  public Product getProductById(Long productId) {
    Optional<Product> optional = productRepository.findById(productId);
    if(optional.isPresent()) {
      return optional.get();
    }
    throw new IllegalStateException("Not found!");
  }
}
