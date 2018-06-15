package com.adev.springexample2.services;

import com.adev.springexample2.model.Person;
import com.adev.springexample2.model.ProductOrder;
import com.adev.springexample2.repositories.PersonRepository;
import com.adev.springexample2.repositories.ProductOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final ProductOrderRepository productOrderRepository;

    public PersonServiceImpl(PersonRepository personRepository, ProductOrderRepository productOrderRepository) {
        this.personRepository = personRepository;
        this.productOrderRepository = productOrderRepository;
    }

    @Override
    public Person getPersonByID(Long id) {
        return personRepository.getOne(id);
    }

    @Override
    public List<Person> findAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public void addPerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        List<ProductOrder> productOrder = productOrderRepository.findAllByPersonID(id);
        if (productOrder.isEmpty())
            personRepository.deleteById(id);
    }
}
