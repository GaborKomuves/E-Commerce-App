package com.diy.e_commerce_app.models;

import com.diy.e_commerce_app.enums.ProductCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Entity class representing a product in the e-commerce application.
 * Maps to the "products" table in the database.
 */
@Entity
@Table(name = "products") // Maps to the "products" table
@Data
@NoArgsConstructor
public class Product {

    /**
     * Primary key of the "products" table.
     * Auto-incremented by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Maps the "id" column
    private Long id;

    /**
     * Name of the product.
     * Maps to the "name" column.
     * Must not be null and has a maximum length of 100 characters.
     */
    @NotNull
    @Size(min = 2, max = 100)
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    /**
     * Price of the product.
     * Maps to the "price" column with precision for monetary values.
     */
    @NotNull
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    /**
     * Optional description of the product.
     * Maps to the "description" column.
     */
    @Column(name = "description", length = 500)
    private String description;

    /**
     * Stock quantity of the product.
     * Maps to the "stock" column.
     * Must not be null.
     */
    @NotNull
    @Column(name = "stock", nullable = false)
    private Integer stock;

    /**
     * Category of the product.
     * Maps to the "category" column.
     * Uses the {@link ProductCategory} enum.
     */
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "category", nullable = false, length = 50)
    private ProductCategory category;
}
