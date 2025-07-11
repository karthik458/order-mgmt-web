package com.telecom.ordermgmt.controller;

import com.telecom.ordermgmt.model.*;
import com.telecom.ordermgmt.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepo;
    private final CustomerRepository customerRepo;
    private final ProductRepository productRepo;

    public OrderController(OrderRepository orderRepo, CustomerRepository customerRepo, ProductRepository productRepo) {
        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
    }

    @GetMapping("/new")
    public String showOrderForm(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("customers", customerRepo.findAll());
        model.addAttribute("products", productRepo.findAll());
        return "order_form";
    }

    @GetMapping("/list")
    public String listOrders(Model model) {
        List<Order> orders = orderRepo.findAll();
        model.addAttribute("orders", orders);
        return "order_list";
    }

    @PostMapping("/save")
    public String saveOrder(@ModelAttribute Order order, @RequestParam Long customerId, @RequestParam List<Long> productIds) {
        order.setCustomer(customerRepo.findById(customerId).orElse(null));
        List<Product> selectedProducts = productRepo.findAllById(productIds);
        order.setProducts(selectedProducts);
        order.setOrderDate(new Date());
        orderRepo.save(order);
        return "redirect:/";
    }
}
