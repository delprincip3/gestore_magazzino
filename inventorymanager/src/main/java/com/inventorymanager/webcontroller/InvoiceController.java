package com.inventorymanager.webcontroller;

import com.inventorymanager.model.Purchase;
import com.inventorymanager.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private PurchaseService purchaseService;

    // Lista di tutte le vendite/fatture
    @GetMapping
    public String listInvoices(Model model) {
        List<Purchase> purchases = purchaseService.getAllPurchases();
        model.addAttribute("purchases", purchases);
        return "invoice/list";
    }

    // Dettaglio di una singola vendita/fattura
    @GetMapping("/{id}")
    public String showInvoiceDetails(@PathVariable Long id, Model model) {
        Purchase purchase = purchaseService.getPurchaseById(id)
                .orElseThrow(() -> new IllegalArgumentException("Fattura non valida con ID: " + id));
        model.addAttribute("purchase", purchase);
        return "invoice/detail";
    }
} 