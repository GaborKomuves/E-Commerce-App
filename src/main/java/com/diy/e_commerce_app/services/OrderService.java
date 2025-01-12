package com.diy.e_commerce_app.services;

import com.diy.e_commerce_app.models.Order;
import com.diy.e_commerce_app.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Creează o comandă
    public Order placeOrder(String customerName, String customerEmail) {
        Order order = new Order();
        order.setCustomerName(customerName);
        order.setCustomerEmail(customerEmail);
        order.setTotalAmount(BigDecimal.valueOf(100.00)); // Valoare fixă pentru testare
        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);
    }

    // Obține toate comenzile
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Obține o comandă după ID
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
    }

    // Șterge o comandă după ID
    public void deleteOrder(Long orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new RuntimeException("Order not found with ID: " + orderId);
        }
        orderRepository.deleteById(orderId);
    }

    // Actualizează o comandă existentă
    public Order updateOrder(Long orderId, Order updatedOrder) {
        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

        // Actualizează câmpurile comenzii
        existingOrder.setCustomerName(updatedOrder.getCustomerName());
        existingOrder.setCustomerEmail(updatedOrder.getCustomerEmail());
        existingOrder.setTotalAmount(updatedOrder.getTotalAmount());
        existingOrder.setOrderDate(updatedOrder.getOrderDate());

        return orderRepository.save(existingOrder);
    }
}


