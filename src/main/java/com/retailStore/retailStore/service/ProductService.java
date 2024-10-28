//package com.retailStore.retailStore.service;
//
//import com.retailStore.retailStore.model.Category;
//import com.retailStore.retailStore.model.Products;
//import com.retailStore.retailStore.model.Seller;
//import com.retailStore.retailStore.repository.CategoryRepository;
//import com.retailStore.retailStore.repository.ProductRepository;
//import com.retailStore.retailStore.repository.SellerRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ProductService {
//
//    @Autowired
//    private ProductRepository productRepository;
//    
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @Autowired
//    private SellerRepository sellerRepository;
//
//    // Retrieve all products
//    public List<Products> getAllProducts() {
//        return productRepository.findAll();
//    }
//
//    // Retrieve a product by ID
//    public Optional<Products> getProductById(Long id) {
//        return productRepository.findById(id);
//    }
//
//    // Add a new product 
//    public Products addProduct(Products product, Long categoryId, Long sellerId) {
//    	Category category = categoryRepository.findById(categoryId)
//                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryId));
//
//        // Fetch the associated seller
//        Seller seller = sellerRepository.findById(sellerId)
//                .orElseThrow(() -> new RuntimeException("Seller not found with ID: " + sellerId));
//
//        // Set the category and seller for the product
//        product.setCategory(category);
//        product.setSeller(seller);
//    	
//        return productRepository.save(product);
//    }
//
//    // Update an existing product
//    public Products updateProduct(Long id, Products productDetails) {
//        Products product = productRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Product not found"));
//
//        product.setProductName(productDetails.getProductName());
//        product.setPrice(productDetails.getPrice());
//        product.setStock(productDetails.getStock());
//        
//        if (productDetails.getCategory() != null) {
//            product.setCategory(productDetails.getCategory());
//        }
//        if (productDetails.getSeller() != null) {
//            product.setSeller(productDetails.getSeller());
//        }
//
//        return productRepository.save(product);
//    }
//
//    // Delete a product by ID
//    public void deleteProduct(Long id) {
//        productRepository.deleteById(id);
//    }
//}

package com.retailStore.retailStore.service;

import com.retailStore.retailStore.model.Products;
import com.retailStore.retailStore.model.Category;
import com.retailStore.retailStore.model.Seller;
import com.retailStore.retailStore.repository.ProductRepository;
import com.retailStore.retailStore.repository.CategoryRepository;
import com.retailStore.retailStore.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productsRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SellerRepository sellerRepository;

    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    public Optional<Products> getProductById(Long id) {
        return productsRepository.findById(id);
    }

    public Products addProduct(Products product, Long categoryId, Long sellerId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        Optional<Seller> seller = sellerRepository.findById(sellerId);

        if (!category.isPresent()) {
            throw new RuntimeException("Category not found with id: " + categoryId);
        }

        if (!seller.isPresent()) {
            throw new RuntimeException("Seller not found with id: " + sellerId);
        }

        product.setCategory(category.get());
        product.setSeller(seller.get());

        return productsRepository.save(product);
    }

    public Products updateProduct(Long id, Products productDetails) {
        Products product = productsRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setProductName(productDetails.getProductName());
        product.setPrice(productDetails.getPrice());
        product.setStock(productDetails.getStock());
        product.setImage(productDetails.getImage());

        return productsRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productsRepository.deleteById(id);
    }
}

