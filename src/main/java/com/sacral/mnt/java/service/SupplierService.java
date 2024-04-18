package com.sacral.mnt.java.service;

import com.sacral.mnt.java.model.Supplier;
import com.sacral.mnt.java.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Supplier findByEmail(String email) {
        return supplierRepository.findByEmail(email);
    }

    public boolean existsByEmail(String email) {
        return supplierRepository.existsByEmail(email);
    }

    // Add more business methods here if needed
}