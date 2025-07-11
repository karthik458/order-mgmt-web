package com.telecom.ordermgmt.repository;

import com.telecom.ordermgmt.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}