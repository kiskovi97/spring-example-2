package com.adev.springexample2.controllers;

import com.adev.springexample2.model.Person;
import com.adev.springexample2.model.Product;
import com.adev.springexample2.model.ProductOrder;
import com.adev.springexample2.services.PersonService;
import com.adev.springexample2.services.ProductOrderService;
import com.adev.springexample2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductOrderController {

    private ProductOrderService productOrderService;

    private ProductService productService;

    private PersonService personService;

    @Autowired
    public ProductOrderController(ProductOrderService productOrderService, ProductService productService, PersonService personService) {
        this.productOrderService = productOrderService;
        this.productService = productService;
        this.personService = personService;
    }

    @GetMapping({"/productorders"})
    public String showProductOrders(Model model) {
        model.addAttribute( "persons", personService.findAllPerson());
        model.addAttribute( "products", productService.findAllProduct());
        model.addAttribute("productorders", productOrderService.findAllProductOrder());
        ProductOrder productOrder = new ProductOrder();
        productOrder.setProduct(new Product());
        productOrder.setPerson(new Person());
        model.addAttribute("productOrder", productOrder);
        return "ProductOrderPage";
    }

    @PostMapping("/productorders")
    public String addProductOrder(@ModelAttribute ProductOrder productOrder) {
        productOrderService.addProductOrder(productOrder);
        return "redirect:/productorders";
    }

    @RequestMapping(value = "/productorders/{id}/delete")
    public String deleteProductOrder(@PathVariable String id) {
        productOrderService.deleteProductOrder(Long.parseLong(id));
        return "redirect:/productorders";
    }

    @RequestMapping("/productorders/{id}")
    public String showProductOrderById(Model model, @PathVariable Long id) {
        model.addAttribute("productorders", productOrderService.getProductOrderByID(id));
        return "ProductOrderPage";
    }
}
