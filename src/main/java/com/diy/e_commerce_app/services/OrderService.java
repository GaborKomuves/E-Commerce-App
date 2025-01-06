package com.diy.e_commerce_app.services;

import com.diy.e_commerce_app.models.CartItem;
import com.diy.e_commerce_app.models.Order;
import com.diy.e_commerce_app.models.Product;
import com.diy.e_commerce_app.repositories.OrderRepository;
import com.diy.e_commerce_app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Service for managing orders.
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductRepository productRepository;

    /**
     * Places an order based on the current cart items.
     *
     * @param customerName  the customer's name.
     * @param customerEmail the customer's email address.
     * @return the created order.
     */
    public Order placeOrder(String customerName, String customerEmail) {
        // Retrieve cart items
        List<CartItem> cartItems = cartService.getCartItems();

        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        // Calculate total amount
        BigDecimal totalAmount = cartItems.stream()
                .map(item -> item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // Update product stock
        cartItems.forEach(item -> {
            Product product = item.getProduct();
            if (product.getStock() < item.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getName());
            }
            product.setStock(product.getStock() - item.getQuantity());
            productRepository.save(product);
        });

        // Create the order
        Order order = new Order();
        order.setCustomerName(customerName);
        order.setCustomerEmail(customerEmail);
        order.setItems(cartItems);
        order.setTotalAmount(totalAmount);
        order.setOrderDate(LocalDateTime.now());

        // Save and return the order
        return orderRepository.save(order);
    }

    /**
     * Retrieves an order by its ID.
     *
     * @param orderId the ID of the order to retrieve.
     * @return the order.
     */
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
    }

    /**
     * Retrieves all orders.
     *
     * @return a list of all orders.
     */
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Deletes an order by its ID.
     *
     * @param orderId the ID of the order to delete.
     */
    public void deleteOrder(Long orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new RuntimeException("Order not found with ID: " + orderId);
        }
        orderRepository.deleteById(orderId);
    }
}
