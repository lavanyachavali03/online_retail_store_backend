package com.retailStore.retailStore.service;

import com.retailStore.retailStore.model.Products;
import com.retailStore.retailStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Retrieve all products
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    // Retrieve a product by ID
    public Optional<Products> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Add a new product
    public Products addProduct(Products product) {
        return productRepository.save(product);
    }

    // Update an existing product
    public Products updateProduct(Long id, Products productDetails) {
        Products product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setProductName(productDetails.getProductName());
        product.setPrice(productDetails.getPrice());
        product.setStock(productDetails.getStock());

        return productRepository.save(product);
    }

    // Delete a product by ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
