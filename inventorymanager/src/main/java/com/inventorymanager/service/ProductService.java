package com.inventorymanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanager.model.Product;
import com.inventorymanager.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String code) {
        return productRepository.findById(code);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(String code) {
        productRepository.deleteById(code);
    }

    public void sellProduct(String code, int quantity) {
        Optional<Product> productOpt = productRepository.findById(code);
        
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            
            if (product.getQuantity() >= quantity) {
                product.setQuantity(product.getQuantity() - quantity);
                productRepository.save(product);
            } else {
                throw new IllegalArgumentException("Quantità richiesta non disponibile");
            }
        } else {
            throw new IllegalArgumentException("Prodotto non trovato");
        }
    }

    public Optional<Product> findProductById(String code) {
        return productRepository.findById(code);
    }
}