package com.inventorymanager.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
 
    @ManyToOne
    private Product product;

    @ManyToOne
    private Customer customer;

    private LocalDate date;
    private Integer quantity;

}   

