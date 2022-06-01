package com.letscode.cart.service;

import com.letscode.cart.dto.ProductDTO;
import com.letscode.cart.model.Cart;
import com.letscode.cart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImp implements CartService{

  private final CartRepository cartRepository;

  @Override
  public Cart addProductToCart(Cart cart) {
    return cartRepository.save(cart);
  }

  @Override
  public List<Cart> getAllProductsInCart() {
    return cartRepository.findAll();
  }

  @Override
  public void deleteProductInCartById(Long productId) {

  }

  @Override
  public void updateProductInCart(Long productId, ProductDTO product) {

  }
}
