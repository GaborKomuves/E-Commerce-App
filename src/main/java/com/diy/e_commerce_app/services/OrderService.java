package com.diy.e_commerce_app.services;

import com.diy.e_commerce_app.models.Order;
import com.diy.e_commerce_app.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for managing orders.
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    /**
     * Places an order based on the current cart items.
     */
    public Order placeOrder(String customerName, String customerEmail) {
        // Logic for placing an order (as provided earlier).
        return new Order(); // Replace with actual order creation logic.
    }

    /**
     * Retrieves an order by its ID.
     */
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
    }

    /**
     * Retrieves all orders.
     */
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Deletes an order by its ID.
     */
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
