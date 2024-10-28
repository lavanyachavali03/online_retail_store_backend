//package com.retailStore.retailStore.controller;
//
//import com.retailStore.retailStore.dto.CategoryDTO;
//import com.retailStore.retailStore.dto.ProductDTO;
//import com.retailStore.retailStore.model.Products;
//import com.retailStore.retailStore.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/products")
//public class ProductsController {
//
//    @Autowired
//    private ProductService productService;
//
//    // Get all products
//    @GetMapping
//    public List<ProductDTO> getAllProducts() {
//        List<Products> products = productService.getAllProducts();
//        return products.stream().map(this::convertToDTO).collect(Collectors.toList());
//    }
//
//    // Get a product by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
//        Optional<Products> product = productService.getProductById(id);
//        return product.map(this::convertToDTO)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    // Create a new product
//    @PostMapping
//    public Products createProduct(@RequestParam Long category_id,
//                                  @RequestParam Long seller_id, 
//                                  @RequestBody Products product) {
//        return productService.addProduct(product, category_id, seller_id);
//    }
//
//    // Update an existing product
//    @PutMapping("/{id}")
//    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, 
//                                                    @RequestBody Products productDetails) {
//        Products updatedProduct = productService.updateProduct(id, productDetails);
//        return ResponseEntity.ok(convertToDTO(updatedProduct));
//    }
//
//    // Delete a product by ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
//        productService.deleteProduct(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    private ProductDTO convertToDTO(Products product) {
//        CategoryDTO categoryDTO = new CategoryDTO(
//            product.getCategory().getId(),
//            product.getCategory().getCategoryName(),
//            product.getCategory().getDescription()
//        );
//        return new ProductDTO(
//            product.getId(),
//            product.getProductName(),
//            product.getPrice(),
//            product.getStock(),
//            categoryDTO
//        );
//    }
//}








//
//package com.retailStore.retailStore.controller;
//
//import com.retailStore.retailStore.dto.CategoryDTO;
//import com.retailStore.retailStore.dto.ProductDTO;
//import com.retailStore.retailStore.model.Products;
//import com.retailStore.retailStore.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/products")
//public class ProductsController {
//
//    @Autowired
//    private ProductService productService;
//
//    // Get all products
//    @GetMapping
//    public List<Products> getAllProducts() {
//        return productService.getAllProducts();
//    }
//
//    // Get a product by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Products> getProductById(@PathVariable Long id) {
//        Optional<Products> product = productService.getProductById(id);
//        return product.map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    // Create a new product
////    @PostMapping
////    public Products createProduct(@RequestParam Long categoryId,
////            @RequestParam Long sellerId, @RequestBody Products product) {
////        return productService.addProduct(product, categoryId, sellerId);
////    }
//    @PostMapping
//    public Products createProduct(@RequestBody Products product) {
//        return productService.addProduct(product);
//    }
//
//    // Update an existing product
//    @PutMapping("/{id}")
//    public ResponseEntity<Products> updateProduct(@PathVariable Long id, @RequestBody Products productDetails) {
//        Products updatedProduct = productService.updateProduct(id, productDetails);
//        return ResponseEntity.ok(updatedProduct);
//    }
//
//    // Delete a product by ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
//        productService.deleteProduct(id);
//        return ResponseEntity.noContent().build();
//    }
//    
//    private ProductDTO convertToDTO(Products product) {
//        CategoryDTO categoryDTO = new CategoryDTO(
//            product.getCategory().getId(),
//            product.getCategory().getCategoryName(),
//            product.getCategory().getDescription()
//        );
//        return new ProductDTO(
//            product.getId(),
//            product.getProductName(),
//            product.getPrice(),
//            product.getStock(),
//            categoryDTO
//        );
//    }
//}







package com.retailStore.retailStore.controller;

import com.retailStore.retailStore.model.Products;
import com.retailStore.retailStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    // Get all products
    @GetMapping
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get a product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable Long id) {
        Optional<Products> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new product
    @PostMapping
    public Products createProduct(@RequestBody ProductRequest productRequest) {
        Products product = new Products();
        product.setProductName(productRequest.getProductName());
        product.setPrice(productRequest.getPrice());
        product.setStock(productRequest.getStock());
        product.setImage(productRequest.getImage()); // Set image field
        return productService.addProduct(product, productRequest.getCategoryId(), productRequest.getSellerId());
    }

    // Update an existing product
    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable Long id, @RequestBody Products productDetails) {
        productDetails.setImage(productDetails.getImage()); // Update image field
        Products updatedProduct = productService.updateProduct(id, productDetails);
        return ResponseEntity.ok(updatedProduct);
    }

    // Delete a product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
    	productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    // DTO to handle the incoming request
    public static class ProductRequest {
        private String productName;
        private double price;
        private int stock;
        private Long categoryId;
        private Long sellerId;
        private String image; // New field for image

        // Getters and setters
        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public Long getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Long categoryId) {
            this.categoryId = categoryId;
        }

        public Long getSellerId() {
            return sellerId;
        }

        public void setSellerId(Long sellerId) {
            this.sellerId = sellerId;
        }

        public String getImage() { // Getter for image
            return image;
        }

        public void setImage(String image) { // Setter for image
            this.image = image;
        }
    }

}

