package com.inventorymanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanager.model.Customer;
import com.inventorymanager.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer saveCustomer(Customer Customer) {
        return customerRepository.save(Customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public Optional<Customer> findByCodiceFiscale(String codiceFiscale) {
        return customerRepository.findAll().stream()
                .filter(c -> c.getCodiceFiscale().equals(codiceFiscale))
                .findFirst();
    }
}