package com.diy.e_commerce_app.services;

import com.diy.e_commerce_app.models.Product;
import com.diy.e_commerce_app.enums.ProductCategory;
import com.diy.e_commerce_app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Service class providing business logic for managing products.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    public Product getProductByName(String name) {
        return productRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("Product not found with name: " + name));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = getProductById(id);
        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        product.setDescription(updatedProduct.getDescription());
        product.setStock(updatedProduct.getStock());
        product.setCategory(updatedProduct.getCategory());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProductsByCategory(ProductCategory category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }
    public Product getMostExpensiveProduct() {
        return (Product) productRepository.findTopByOrderByPriceDesc()
                .orElseThrow(() -> new RuntimeException("No products available"));
    }

    public List<Product> getLowStockProducts(Integer threshold) {
        return productRepository.findByStockLessThan(threshold);
    }


}
