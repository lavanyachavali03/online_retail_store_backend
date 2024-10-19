package com.retailStore.retailStore.controller;

import com.retailStore.retailStore.model.Seller;
import com.retailStore.retailStore.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    // Get all sellers
    @GetMapping
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }

    // Get a seller by ID
    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable Long id) {
        Optional<Seller> seller = sellerService.getSellerById(id);
        return seller.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new seller
    @PostMapping
    public Seller createSeller(@RequestBody Seller seller) {
        return sellerService.addSeller(seller);
    }

    // Update an existing seller
    @PutMapping("/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable Long id, @RequestBody Seller sellerDetails) {
        Seller updatedSeller = sellerService.updateSeller(id, sellerDetails);
        return ResponseEntity.ok(updatedSeller);
    }
    
 // Disable a seller by ID
    @PutMapping("/{id}/disable")
    public ResponseEntity<Seller> disableSeller(@PathVariable Long id) {
        Seller disabledSeller = sellerService.disableSeller(id);
        return ResponseEntity.ok(disabledSeller);
    }

    // Delete a seller by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable Long id) {
        sellerService.deleteSeller(id);
        return ResponseEntity.noContent().build();
    }
}
