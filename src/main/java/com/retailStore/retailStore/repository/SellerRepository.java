package com.retailStore.retailStore.repository;


import com.retailStore.retailStore.model.Seller; // Import your Order entity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    // Custom query methods if needed
}
