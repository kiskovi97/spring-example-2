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

    @GetMapping({"/product"})
    public String showProductPage(Model model) {
        model.addAttribute("products", productService.findAllProduct());
        model.addAttribute("product", new Product());
        return "ProductPage";
    }

    @PostMapping("/product_add")
    public String addProduct(Model model, @ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/product";
    }

    @RequestMapping(value = "/delete_product/{stringID}")
    public String handleDeleteProduct(Model model, @PathVariable String stringID) {
        long longID = Long.parseLong(stringID);
        productService.deleteProduct(longID);
        return "redirect:/product";
    }


    @RequestMapping("/productbyID/{id}")
    public String showProductbyID(Model model, @PathVariable Long id) {
        model.addAttribute("products", productService.getProductByID(id));
        return "ProductPage";
    }
}
