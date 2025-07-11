package com.telecom.ordermgmt.repository;

import com.telecom.ordermgmt.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
