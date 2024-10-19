package com.retailStore.retailStore.repository;

import com.retailStore.retailStore.model.Products; // Import your Product entity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    // You can define custom query methods here if needed
}