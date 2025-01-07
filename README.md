E-Commerce Application

This is a simple E-Commerce Application built using Spring Boot. It supports product management, order placement, and basic cart functionality.

Features

Product Management: Add, update, delete, and retrieve products.

Order Placement: Place orders based on cart items.

Cart Functionality: Add items to the cart and calculate total amounts.

RESTful API: Endpoints for managing orders, products, and cart.

PostgreSQL Database: Used for storing products, orders, and cart items.

Prerequisites

Java: Version 17 or higher.

Maven: For building and managing dependencies.

PostgreSQL: A running PostgreSQL instance.

Postman (or any API client): For testing the API.

Setup Instructions

Clone the repository:

git clone https://github.com/your-repo/ecommerce-app.git
cd ecommerce-app

Update the database configuration in src/main/resources/application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

Build the project using Maven:

mvn clean install

Run the application:

mvn spring-boot:run

Access the API at:

http://localhost:8080/api

API Endpoints

Product Endpoints

GET /api/products - Retrieve all products.

GET /api/products/{id} - Retrieve a product by ID.

POST /api/products - Add a new product.

PUT /api/products/{id} - Update a product by ID.

DELETE /api/products/{id} - Delete a product by ID.

Order Endpoints

POST /api/orders/place - Place a new order.

Request Body:

{
"customerName": "John Doe",
"customerEmail": "john.doe@example.com"
}

GET /api/orders - Retrieve all orders.

GET /api/orders/{id} - Retrieve an order by ID.

DELETE /api/orders/{id} - Delete an order by ID.

Testing the API

Use Postman or any API client to test the endpoints. Example for placing an order:

Endpoint: POST /api/orders/place

Headers:

Content-Type: application/json

Body:

{
"customerName": "John Doe",
"customerEmail": "john.doe@example.com"
}

Technologies Used

Spring Boot: Framework for building the application.

PostgreSQL: Database for persisting data.

Maven: Dependency management and build tool.

Lombok: Simplify Java boilerplate code.

Future Enhancements

Implement authentication and authorization.

Add user management.

Enhance cart functionality with session handling.

