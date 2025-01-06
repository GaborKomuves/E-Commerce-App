package com.diy.e_commerce_app.enums;

/**
 * Enumeration representing the categories of products in the e-commerce application.
 *
 * <p>
 * This enum is used to classify products into predefined categories to facilitate
 * filtering, searching, and organizing products within the application.
 * </p>
 *
 * Categories:
 * <ul>
 *     <li>{@link #PPE} - Personal Protective Equipment</li>
 *     <li>{@link #TOOLS} - Tools and related equipment</li>
 *     <li>{@link #ELECTRONICS} - Electronic devices and accessories</li>
 * </ul>
 */
public enum ProductCategory {
    /**
     * Category for Personal Protective Equipment (PPE).
     * Includes items like gloves, helmets, and safety goggles.
     */
    PPE,

    /**
     * Category for tools and related equipment.
     * Includes hand tools, power tools, and related accessories.
     */
    TOOLS,

    /**
     * Category for electronics.
     * Includes devices like smartphones, laptops, and accessories.
     */
    ELECTRONICS
}

