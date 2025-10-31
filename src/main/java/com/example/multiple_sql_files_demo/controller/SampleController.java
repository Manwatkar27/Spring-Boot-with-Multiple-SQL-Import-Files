package com.example.multiple_sql_files_demo.controller;

import com.example.multiple_sql_files_demo.model.Product;
import com.example.multiple_sql_files_demo.model.User;
import com.example.multiple_sql_files_demo.repository.ProductRepository;
import com.example.multiple_sql_files_demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SampleController {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public SampleController(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
