package com.diy.e_commerce_app.controllers;

import com.diy.e_commerce_app.models.Product;
import com.diy.e_commerce_app.enums.ProductCategory;
import com.diy.e_commerce_app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * REST controller for managing products in the e-commerce application.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/search")
    public Product getProductByName(@RequestParam String name) {
        return productService.getProductByName(name);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/by-category")
    public List<Product> getProductsByCategory(@RequestParam ProductCategory category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/by-price")
    public List<Product> getProductsByPriceRange(@RequestParam BigDecimal minPrice, @RequestParam BigDecimal maxPrice) {
        return productService.getProductsByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/most-expensive")
    public Product getMostExpensiveProduct() {
        return productService.getMostExpensiveProduct();
    }

    @GetMapping("/low-stock")
    public List<Product> getLowStockProducts(@RequestParam("threshold") Integer threshold) {
        return productService.getLowStockProducts(threshold);
    }
}
