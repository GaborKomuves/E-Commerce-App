package com.diy.e_commerce_app.repositories;

import com.diy.e_commerce_app.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repozitoriu pentru entitatea Order.
 * Asigură operații CRUD pentru tabela "orders".
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
