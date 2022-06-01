package com.letscode.cart.controller;

import com.letscode.cart.client.CartClient;
import com.letscode.cart.dto.ProductDTO;
import com.letscode.cart.model.Cart;
import com.letscode.cart.service.CartServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
  private final CartServiceImp cartServiceImp;

  @Autowired
  private CartClient cartClient;

  @PostMapping
  public ResponseEntity<Cart> addProductToCart(@RequestBody Cart cart) {
    System.out.println("Cart: " + cart.getUserId());
    return ResponseEntity.ok().body(cartServiceImp.addProductToCart(cart));
  }

  @GetMapping
  public ResponseEntity<List<Cart>> getProductsInCart() {
    // Faz a chamada via OpenFeign para o microsserviço Produto

    for (ProductDTO product : cartClient.getAllProducts()) {
      System.out.println("PRODUCTS REGISTERED: " + product.getProductId());
    }
    return ResponseEntity.ok(cartServiceImp.getAllProductsInCart());
  }

  @GetMapping("/product/{productId}")
  public ResponseEntity<ProductDTO> getProductById(@PathVariable Long productId) {
    return ResponseEntity.ok().body(cartClient.getProductById(productId));
  }
}
