package com.letscode.cart.model;

import com.letscode.cart.dto.ProductDTO;
import com.letscode.cart.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart")
public class Cart {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long cartId;

  @CreationTimestamp
  private Date createdAt;

  // Interface usada somente para definir qual a estrutura adotada pelo microsserviço de produto
  @Embedded
  private ProductDTO product;
  // Interface usada somente para definir qual a estrutura adotada pelo microsserviço de usuário
  @Embedded
  private UserDTO user;

  private Long quantity;

}
