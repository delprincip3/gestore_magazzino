package com.inventorymanager.webcontroller;

import com.inventorymanager.model.Product;
import com.inventorymanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Lista di tutti i prodotti
    @GetMapping
    public String listProducts(Model model) {
        List<Product> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "product/list";
    }

    // Form per aggiungere un nuovo prodotto
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/form";
    }

    // Salvataggio di un nuovo prodotto
    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("product") Product product, 
                            BindingResult result) {
        if (result.hasErrors()) {
            return "product/form";
        }
        
        productService.saveProduct(product);
        return "redirect:/products";
    }

    // Form per modificare un prodotto esistente
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Product product = productService.findProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Prodotto non valido con codice: " + id));
        model.addAttribute("product", product);
        return "product/form";
    }

    // Aggiornamento di un prodotto esistente
    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable String id, 
                               @Valid @ModelAttribute("product") Product product,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "product/form";
        }
        
        product.setCode(id);
        productService.saveProduct(product);
        return "redirect:/products";
    }

    // Eliminazione di un prodotto
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    // Form per vendere un prodotto
    @GetMapping("/sell/{id}")
    public String showSellForm(@PathVariable String id, Model model) {
        Product product = productService.findProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Prodotto non valido con codice: " + id));
        model.addAttribute("product", product);
        model.addAttribute("quantity", 1);
        return "product/sell";
    }

    // Processare la vendita di un prodotto
    @PostMapping("/sell/{id}")
    public String sellProduct(@PathVariable String id, 
                             @RequestParam("quantity") int quantity,
                             RedirectAttributes redirectAttributes) {
        try {
            productService.sellProduct(id, quantity);
            return "redirect:/products";
        } catch (IllegalArgumentException e) {
            redirectAttributes.addAttribute("error", true);
            return "redirect:/products/sell/" + id;
        }
    }
} 