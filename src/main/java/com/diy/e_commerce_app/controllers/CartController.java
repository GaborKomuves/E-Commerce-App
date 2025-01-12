package com.diy.e_commerce_app.controllers;

import com.diy.e_commerce_app.models.CartItem;
import com.diy.e_commerce_app.services.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart") // Prefix pentru toate endpoint-urile din acest controller
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    /**
     * Adaugă un element în coș.
     *
     * @param requestBody JSON care conține productId și quantity
     * @return Elementul adăugat în coș
     */
    @PostMapping("/add")
    public CartItem addCartItem(@RequestBody Map<String, Object> requestBody) {
        Long productId = Long.valueOf(requestBody.get("productId").toString());
        Integer quantity = Integer.valueOf(requestBody.get("quantity").toString());
        return cartService.addCartItem(productId, quantity);
    }

    /**
     * Actualizează cantitatea unui element din coș.
     *
     * @param id ID-ul elementului din coș
     * @param updatedCartItem Obiectul cu datele actualizate
     * @return Elementul actualizat
     */
    @PutMapping("/items/{id}")
    public CartItem updateCartItem(@PathVariable Long id, @RequestBody CartItem updatedCartItem) {
        return cartService.updateCartItem(id, updatedCartItem);
    }

    /**
     * Obține toate elementele din coș.
     *
     * @return Lista cu toate elementele din coș
     */
    @GetMapping("/items")
    public List<CartItem> getCartItems() {
        return cartService.getCartItems();
    }

    /**
     * Șterge un element din coș.
     *
     * @param cartItemId ID-ul elementului care trebuie șters
     */
    @DeleteMapping("/delete/{cartItemId}")
    public void deleteCartItem(@PathVariable Long cartItemId) {
        cartService.deleteCartItem(cartItemId);
    }
}
