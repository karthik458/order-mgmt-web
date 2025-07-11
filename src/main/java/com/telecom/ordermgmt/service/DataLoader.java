package com.telecom.ordermgmt.service;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.telecom.ordermgmt.model.Customer;
import com.telecom.ordermgmt.model.Product;
import com.telecom.ordermgmt.repository.CustomerRepository;
import com.telecom.ordermgmt.repository.ProductRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepo;
    private final ProductRepository productRepo;

    public DataLoader(CustomerRepository customerRepo, ProductRepository productRepo) {
        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
    }

    @Override
    public void run(String... args) {
        if (customerRepo.count() == 0) {
            customerRepo.saveAll(Arrays.asList(
                    new Customer(null, "John Doe", "john@example.com"),
                    new Customer(null, "Alice Smith", "alice@example.com")
            ));
        }

        if (productRepo.count() == 0) {
            productRepo.saveAll(Arrays.asList(
                    new Product(null, "Broadband Plan", 999.99),
                    new Product(null, "Mobile Recharge", 299.00),
                    new Product(null, "OTT Add-on", 149.50)
            ));
        }
    }
}