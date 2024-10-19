package com.retailStore.retailStore.controller;

import com.retailStore.retailStore.model.CustomerOrder;
import com.retailStore.retailStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer-orders")
public class OrderController {

    @Autowired
    private OrderService customerOrderService;

    // Get all customer orders
    @GetMapping
    public List<CustomerOrder> getAllCustomerOrders() {
        return customerOrderService.getAllCustomerOrders();
    }

    // Get a customer order by ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerOrder> getCustomerOrderById(@PathVariable Long id) {
        Optional<CustomerOrder> order = customerOrderService.getCustomerOrderById(id);
        return order.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new customer order
    @PostMapping
    public CustomerOrder createCustomerOrder(@RequestBody CustomerOrder customerOrder) {
        return customerOrderService.addCustomerOrder(customerOrder);
    }

    // Update an existing customer order
    @PutMapping("/{id}")
    public ResponseEntity<CustomerOrder> updateCustomerOrder(@PathVariable Long id, @RequestBody CustomerOrder orderDetails) {
        CustomerOrder updatedOrder = customerOrderService.updateCustomerOrder(id, orderDetails);
        return ResponseEntity.ok(updatedOrder);
    }

    // Delete a customer order by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerOrder(@PathVariable Long id) {
        customerOrderService.deleteCustomerOrder(id);
        return ResponseEntity.noContent().build();
    }
}
