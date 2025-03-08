package com.inventorymanager.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    
    @GetMapping("/index")
    public String showMenu() {
        return "index";
    }
    
    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    @GetMapping("/prodotti")
    public String listaProdotti() {
        return "redirect:/products";
    }
    
    @GetMapping("/nuovoprodotto")
    public String aggiungiProdotto() {
        return "redirect:/products/add";
    }
    
    @GetMapping("/vendita")
    public String venditaProdotti() {
        return "redirect:/products";
    }
    
    @GetMapping("/clienti")
    public String listaClienti() {
        return "redirect:/customers";
    }
    
    @GetMapping("/nuovocliente")
    public String aggiungiCliente() {
        return "redirect:/customers/add";
    }
    
    @GetMapping("/fatture")
    public String listaFatture() {
        return "redirect:/invoices";
    }
}
