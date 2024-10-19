package com.retailStore.retailStore.service;

import com.retailStore.retailStore.model.Seller;
import com.retailStore.retailStore.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    // Retrieve all sellers
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    // Retrieve a seller by ID
    public Optional<Seller> getSellerById(Long id) {
        return sellerRepository.findById(id);
    }

    // Add a new seller
    public Seller addSeller(Seller seller) {
    	 seller.setStatus("Active"); 
        return sellerRepository.save(seller);
    }

    // Update an existing seller
    public Seller updateSeller(Long id, Seller sellerDetails) {
        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seller not found"));

        seller.setSellerName(sellerDetails.getSellerName());
        seller.setEmail(sellerDetails.getEmail());
//        seller.setStatus(sellerDetails.getStatus()); 

        return sellerRepository.save(seller);
    }
    public Seller disableSeller(Long id) {
        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seller not found"));

        seller.setStatus("Disabled");
        return sellerRepository.save(seller);
    }

    // Delete a seller by ID
    public void deleteSeller(Long id) {
        sellerRepository.deleteById(id);
    }
}
