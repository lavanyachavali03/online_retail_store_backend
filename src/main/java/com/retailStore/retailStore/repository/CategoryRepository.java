package com.retailStore.retailStore.repository;

import com.retailStore.retailStore.model.Category; // Import your Product entity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // You can define custom query methods here if needed
}