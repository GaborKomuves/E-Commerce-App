package com.diy.e_commerce_app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * DTO for placing an order.
 */
@Data
public class PlaceOrderRequest {

    @NotNull
    private String customerName;

    @NotNull
    @Email
    private String customerEmail;
}
