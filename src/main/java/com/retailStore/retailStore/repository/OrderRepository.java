package com.retailStore.retailStore.repository;


import com.retailStore.retailStore.model.CustomerOrder;// Import your Order entity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {
    // Custom query methods if needed
}
