package com.inventorymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventorymanager.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> { }
