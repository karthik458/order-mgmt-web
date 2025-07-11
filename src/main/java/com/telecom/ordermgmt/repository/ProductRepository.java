package com.telecom.ordermgmt.repository;

import com.telecom.ordermgmt.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
