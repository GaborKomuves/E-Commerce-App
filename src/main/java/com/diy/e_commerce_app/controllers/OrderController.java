package com.diy.e_commerce_app.controllers;

import com.diy.e_commerce_app.dto.PlaceOrderRequest;
import com.diy.e_commerce_app.models.Order;
import com.diy.e_commerce_app.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing orders in the e-commerce application.
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {


    private final OrderService orderService;//am sters @Autowired si facut final

    public OrderController ( OrderService orderService ) {
        this.orderService = orderService;
    }

    /**
     * Places a new order based on the current cart items.
     *
     * @param request  the customer's name.
     * @return the created order.
     */
    @PostMapping("/place")
    public Order placeOrder(@RequestBody PlaceOrderRequest request) {
        System.out.println("Placing order for: " + request.getCustomerName());
        return orderService.placeOrder(request.getCustomerName(), request.getCustomerEmail());
    }



    /**
     * Retrieves the details of a specific order by ID.
     *
     * @param orderId the ID of the order to retrieve.
     * @return the order details.
     */
    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    /**
     * Retrieves all orders placed in the system.
     *
     * @return a list of all orders.
     */
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    /**
     * Deletes a specific order by ID.
     *
     * @param orderId the ID of the order to delete.
     */
    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }
}

