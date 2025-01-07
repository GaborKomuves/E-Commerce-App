package com.diy.e_commerce_app.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents an order in the e-commerce application.
 */
@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal totalAmount;

    @NotNull
    private String itemsDescription; // Placeholder for items' description (e.g., "Product A x 2, Product B x 1")

    @NotNull
    private String customerName;

    @NotNull
    @Email
    private String customerEmail;

    private LocalDateTime orderDate;


    public void setItems ( List<CartItem> cartItems ) {
    }
}
