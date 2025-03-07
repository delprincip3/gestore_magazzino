package com.inventorymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventorymanager.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long>  {}
