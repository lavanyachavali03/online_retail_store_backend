package com.retailStore.retailStore.service;



import com.retailStore.retailStore.model.CustomerOrder;
import com.retailStore.retailStore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository customerOrderRepository;

    // Retrieve all customer orders
    public List<CustomerOrder> getAllCustomerOrders() {
        return customerOrderRepository.findAll();
    }

    // Retrieve a customer order by ID
    public Optional<CustomerOrder> getCustomerOrderById(Long id) {
        return customerOrderRepository.findById(id);
    }

    // Add a new customer order
    public CustomerOrder addCustomerOrder(CustomerOrder customerOrder) {
        return customerOrderRepository.save(customerOrder);
    }

    // Update an existing customer order
    public CustomerOrder updateCustomerOrder(Long id, CustomerOrder orderDetails) {
        CustomerOrder order = customerOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setCustomer(orderDetails.getCustomer());
        order.setTotalAmount(orderDetails.getTotalAmount());

        return customerOrderRepository.save(order);
    }

    // Delete a customer order by ID
    public void deleteCustomerOrder(Long id) {
        customerOrderRepository.deleteById(id);
    }
}
