package com.letscode.cart.service;

import com.letscode.cart.client.CartClient;
import com.letscode.cart.client.UserClient;
import com.letscode.cart.dto.ProductDTO;
import com.letscode.cart.dto.UserItemDTO;
import com.letscode.cart.model.Cart;
import com.letscode.cart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImp implements CartService{

  @Autowired
  private CartClient cartClient;

  @Autowired
  private UserClient userClient;

  private final CartRepository cartRepository;

  @Override
  public Cart addProductToCart(Cart cart) {
    // Checks if the user is valid (exists)
    Optional<UserItemDTO> optionalUser = Optional.ofNullable(userClient.getUserById());



    if(optionalUser.isEmpty()) {
      throw new IllegalStateException("User is invalid!");
    }

    // Checks if the product is valid (exists)

    cart.getCartItemsList().forEach(cartItemDTO -> {
      Optional<ProductDTO> optionalProduct = Optional.ofNullable(cartClient.getProductById(cartItemDTO.getProductId()));
      if(optionalProduct.isEmpty()) {
        throw new IllegalStateException("Product is invalid!");
      }

      if(cartItemDTO.getQuantity() > optionalProduct.get().getQuantidade()) {
        throw new IllegalStateException("Amount requested is greater than available for the current product!");
      }
    });

    // checks if the cart product quantity is greater than the current stock for the product

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
