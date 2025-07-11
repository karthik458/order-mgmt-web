package com.telecom.ordermgmt.controller;

import com.telecom.ordermgmt.model.Product;
import com.telecom.ordermgmt.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "product_form";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product) {
        System.out.println("Saving product: " + product);
        repository.save(product);
        return "redirect:/";
    }
}