package com.letscode.cart.service;

import com.letscode.cart.dto.ProductDTO;
import com.letscode.cart.model.Cart;

import java.util.List;

public interface CartService {
  Cart addProductToCart(Cart cart);
  List<Cart> getAllProductsInCart();
  void deleteProductInCartById(Long productId);
  void updateProductInCart(Long productId, ProductDTO product);
}
