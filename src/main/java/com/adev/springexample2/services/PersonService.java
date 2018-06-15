package com.adev.springexample2.services;

import com.adev.springexample2.model.Person;

import java.util.List;

public interface PersonService {
    Person getPersonByID(Long id);

    List<Person> findAllPerson();

    void addPerson(Person person);

    void deletePerson(Long id);
}
