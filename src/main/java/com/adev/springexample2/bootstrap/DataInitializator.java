package com.adev.springexample2.bootstrap;

import com.adev.springexample2.model.Person;
import com.adev.springexample2.model.Product;
import com.adev.springexample2.model.ProductOrder;
import com.adev.springexample2.repositories.PersonRepository;
import com.adev.springexample2.repositories.ProductOrderRepository;
import com.adev.springexample2.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializator implements CommandLineRunner {

    private final PersonRepository personRepository;

    private final ProductRepository productRepository;

    private final ProductOrderRepository productOrderRepository;

    public DataInitializator(PersonRepository personRepository, ProductRepository productRepository, ProductOrderRepository productOrderRepository) {
        this.personRepository = personRepository;
        this.productRepository = productRepository;
        this.productOrderRepository = productOrderRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("Loading Data");

        Person p1 = new Person();
        p1.setName("Chuck Norris");
        p1.setCountry("Everywhere");
        personRepository.save(p1);

        Person p2 = new Person();
        p2.setName("Family Guy");
        p2.setCountry("USA");
        personRepository.save(p2);

        Person p3 = new Person();
        p3.setName("American Dad");
        p3.setCountry("USA");
        personRepository.save(p3);

        Product pr1 = new Product();
        pr1.setName("Love");
        pr1.setPrice(0.0);
        productRepository.save(pr1);

        Product pr2 = new Product();
        pr2.setName("Hate");
        pr2.setPrice(0.0);
        productRepository.save(pr2);

        Product pr3 = new Product();
        pr3.setName("PopCultureReference");
        pr3.setPrice(12.0);
        productRepository.save(pr3);

        ProductOrder po1 = new ProductOrder();
        po1.setPerson(p1);
        po1.setProduct(pr1);
        productOrderRepository.save(po1);

        ProductOrder po2 = new ProductOrder();
        po2.setPerson(p2);
        po2.setProduct(pr1);
        productOrderRepository.save(po2);
    }
}
