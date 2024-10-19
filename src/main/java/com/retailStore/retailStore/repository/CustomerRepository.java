package com.retailStore.retailStore.repository;

import com.retailStore.retailStore.model.Customer; // Import your Customer entity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // You can define custom query methods here if needed
}
