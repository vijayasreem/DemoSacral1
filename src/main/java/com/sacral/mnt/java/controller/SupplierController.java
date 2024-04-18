package com.sacral.mnt.java.controller;

import com.sacral.mnt.java.model.Supplier;
import com.sacral.mnt.java.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/{email}")
    public ResponseEntity<Supplier> findByEmail(@PathVariable String email) {
        Supplier supplier = supplierService.findByEmail(email);
        if (supplier != null) {
            return new ResponseEntity<>(supplier, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/exists/{email}")
    public ResponseEntity<Boolean> existsByEmail(@PathVariable String email) {
        boolean exists = supplierService.existsByEmail(email);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }

    // Add more business methods mappings here if needed
}
