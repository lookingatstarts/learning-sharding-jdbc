package com.learning.repository;

import com.learning.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderRepository extends JpaRepository<Order, Long>,
    JpaSpecificationExecutor<Order> {

}