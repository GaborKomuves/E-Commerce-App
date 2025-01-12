package com.diy.e_commerce_app.controllers;
import com.diy.e_commerce_app.services.OrderService;
import com.diy.e_commerce_app.models.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
    public Order placeOrder(@RequestBody Order request) {
        return orderService.placeOrder(request.getCustomerName(), request.getCustomerEmail());
    }

    // Returnează toate comenzile
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Returnează o comandă după ID
    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    // Actualizează o comandă existentă
    @PutMapping("/{orderId}")
    public Order updateOrder(
            @PathVariable Long orderId,
            @RequestBody Order updatedOrder) {
        return orderService.updateOrder(orderId, updatedOrder);
    }


    // Șterge o comandă după ID
    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }



}
