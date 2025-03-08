package com.inventorymanager.webcontroller;

import com.inventorymanager.model.Customer;
import com.inventorymanager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Lista di tutti i clienti
    @GetMapping
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    // Form per aggiungere un nuovo cliente
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/form";
    }

    // Salvataggio di un nuovo cliente
    @PostMapping("/add")
    public String addCustomer(@Valid @ModelAttribute("customer") Customer customer, 
                            BindingResult result) {
        if (result.hasErrors()) {
            return "customer/form";
        }
        
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    // Form per modificare un cliente esistente
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Customer customer = customerService.getCustomerById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente non valido con ID: " + id));
        model.addAttribute("customer", customer);
        return "customer/form";
    }

    // Aggiornamento di un cliente esistente
    @PostMapping("/edit/{id}")
    public String updateCustomer(@PathVariable Long id, 
                               @Valid @ModelAttribute("customer") Customer customer,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "customer/form";
        }
        
        customer.setId(id);
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    // Eliminazione di un cliente
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }
} 