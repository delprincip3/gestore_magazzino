package com.inventorymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventorymanager.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>  {} 

