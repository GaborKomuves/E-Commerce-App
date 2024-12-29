package com.diy.e_commerce_app.repositories;

import com.diy.e_commerce_app.models.Product;
import com.diy.e_commerce_app.enums.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing {@link Product} entities.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Finds a product by its name (case-insensitive).
     *
     * @param name the name of the product.
     * @return an {@link Optional} containing the product if found.
     */
    Optional<Product> findByNameIgnoreCase(String name);

    /**
     * Finds products by their category.
     *
     * @param category the category of the products.
     * @return a list of products in the specified category.
     */
    List<Product> findByCategory(ProductCategory category);

    /**
     * Finds products within a price range.
     *
     * @param minPrice the minimum price.
     * @param maxPrice the maximum price.
     * @return a list of products in the price range.
     */
    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}
