package com.diy.e_commerce_app.services;

import com.diy.e_commerce_app.models.CartItem;
import com.diy.e_commerce_app.models.Product;
import com.diy.e_commerce_app.repositories.CartRepository;
import com.diy.e_commerce_app.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    /**
     * Adaugă un produs în coș.
     *
     * @param productId ID-ul produsului care trebuie adăugat
     * @param quantity  Cantitatea produsului
     * @return Elementul adăugat în coș
     */
    public CartItem addCartItem( Long productId, Integer quantity) {
        if (quantity == null || quantity <= 0) {
            throw new RuntimeException("Cantitatea trebuie să fie mai mare decât zero");
        }

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Produsul cu ID " + productId + " nu a fost găsit"));

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        return cartRepository.save(cartItem);
    }

    /**
     * Obține toate elementele din coș.
     *
     * @return Lista cu toate elementele din coș
     */
    public List<CartItem> getCartItems() {
        return cartRepository.findAll();
    }

    /**
     * Șterge un element din coș după ID.
     *
     * @param id ID-ul elementului care trebuie șters
     */
    public void deleteCartItem(Long id) {
        if (!cartRepository.existsById(id)) {
            throw new RuntimeException("Elementul din coș cu ID " + id + " nu a fost găsit");
        }
        cartRepository.deleteById(id);
    }

    /**
     * Actualizează un element din coș.
     *
     * @param id ID-ul elementului din coș
     * @param updatedCartItem Obiectul cu noile date
     * @return Elementul actualizat
     */
    public CartItem updateCartItem(Long id, CartItem updatedCartItem) {
        if (updatedCartItem.getQuantity() == null || updatedCartItem.getQuantity() <= 0) {
            throw new RuntimeException("Cantitatea trebuie să fie mai mare decât zero");
        }

        CartItem existingCartItem = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Elementul din coș cu ID " + id + " nu a fost găsit"));

        existingCartItem.setQuantity(updatedCartItem.getQuantity());

        if (updatedCartItem.getProduct() != null) {
            Product product = productRepository.findById(updatedCartItem.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Produsul nu a fost găsit"));
            existingCartItem.setProduct(product);
        }

        return cartRepository.save(existingCartItem);
    }
}
