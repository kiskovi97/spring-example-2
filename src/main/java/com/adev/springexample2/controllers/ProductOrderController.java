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

    @GetMapping({"/productorder"})
    public String showProductOrderPage(Model model) {
        model.addAttribute( "persons", personService.findAllPerson());
        model.addAttribute( "products", productService.findAllProduct());
        model.addAttribute("productorders", productOrderService.findAllProductOrder());
        ProductOrder productOrder = new ProductOrder();
        productOrder.setProduct(new Product());
        productOrder.setPerson(new Person());
        model.addAttribute("productOrder", productOrder);
        model.addAttribute("productInput", new Product());
        model.addAttribute("personInput", new Person());
        return "ProductOrderPage";
    }

    @PostMapping("/productorder_add")
    public String addProductOrder(Model model,  @ModelAttribute ProductOrder productOrder) {
        productOrderService.addProductOrder(productOrder);
        return "redirect:/productorder";
    }

    @RequestMapping(value = "/delete_productorder/{stringID}")
    public String handleDeleteProductOrder(Model model, @PathVariable String stringID) {
        long longID = Long.parseLong(stringID);
        productOrderService.deleteProductOrder(longID);
        return "redirect:/productorder";
    }


    @RequestMapping("/productorderbyID/{id}")
    public String showProductOrderbyID(Model model, @PathVariable Long id) {
        model.addAttribute("productorders", productOrderService.getProductOrderByID(id));
        return "ProductOrderPage";
    }
}
