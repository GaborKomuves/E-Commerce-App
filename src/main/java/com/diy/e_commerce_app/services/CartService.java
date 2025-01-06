package com.diy.e_commerce_app.services;

import com.diy.e_commerce_app.models.CartItem;
import com.diy.e_commerce_app.models.Product;
import com.diy.e_commerce_app.repositories.CartRepository;
import com.diy.e_commerce_app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for managing the shopping cart.
 */
@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    /**
     * Adds a product to the cart or updates its quantity.
     *
     * @param productId the ID of the product to add.
     * @param quantity  the quantity to add.
     * @return the updated cart item.
     */
    public CartItem addToCart(Long productId, Integer quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem cartItem = cartRepository.findByProductId(productId)
                .orElseGet(() -> {
                    CartItem newItem = new CartItem();
                    newItem.setProduct(product);
                    newItem.setQuantity(0);
                    return newItem;
                });

        cartItem.setQuantity(cartItem.getQuantity() + quantity);
        return cartRepository.save(cartItem);
    }

    /**
     * Retrieves all items in the cart.
     *
     * @return a list of cart items.
     */
    public List<CartItem> getCartItems() {
        return cartRepository.findAll();
    }

    /**
     * Removes an item from the cart.
     *
     * @param cartItemId the ID of the cart item to remove.
     */
    public void removeFromCart(Long cartItemId) {
        cartRepository.deleteById(cartItemId);
    }

    /**
     * Clears the cart by deleting all items.
     */
    public void clearCart() {
        cartRepository.deleteAll();
    }
}
