package com.adev.springexample2.controllers;

import com.adev.springexample2.model.Person;
import com.adev.springexample2.model.Product;
import com.adev.springexample2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping({"/products"})
    public String showProducts(Model model) {
        model.addAttribute("products", productService.findAllProduct());
        model.addAttribute("product", new Product());
        return "ProductPage";
    }

    @PostMapping("/products")
    public String addProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }

    @RequestMapping(value = "/products/{stringID}/delete")
    public String deleteProduct(@PathVariable String stringID) {
        long longID = Long.parseLong(stringID);
        productService.deleteProduct(longID);
        return "redirect:/products";
    }

    @RequestMapping("/products/{id}")
    public String showProductById(Model model, @PathVariable Long id) {
        model.addAttribute("products", productService.getProductByID(id));
        return "ProductPage";
    }
}
