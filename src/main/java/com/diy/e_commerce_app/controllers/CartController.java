package com.diy.e_commerce_app.controllers;

import com.diy.e_commerce_app.models.CartItem;
import com.diy.e_commerce_app.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing the shopping cart.
 */
@RestController
@RequestMapping("/api/cart")
public class CartController {


    private final CartService cartService;//l am facut final

    public CartController ( CartService cartService ) {// aici am adugat constructorul
        this.cartService = cartService;
    }

    /**
     * Adds a product to the cart or updates its quantity.
     *
     * @param productId the ID of the product to add.
     * @param quantity  the quantity to add.
     * @return the updated cart item.
     */
    @PostMapping("/add")
    public CartItem addToCart(@RequestParam Long productId, @RequestParam Integer quantity) {
        return cartService.addToCart(productId, quantity);
    }

    /**
     * Retrieves all items in the cart.
     *
     * @return a list of cart items.
     */
    @GetMapping
    public List<CartItem> getCartItems() {
        return cartService.getCartItems();
    }

    /**
     * Removes an item from the cart.
     *
     * @param cartItemId the ID of the cart item to remove.
     */
    @DeleteMapping("/{cartItemId}")
    public void removeFromCart(@PathVariable Long cartItemId) {
        cartService.removeFromCart(cartItemId);
    }

    /**
     * Clears the entire cart.
     */
    @DeleteMapping("/clear")
    public void clearCart() {
        cartService.clearCart();
    }
}
