package com.adev.springexample2.controllers;

import com.adev.springexample2.model.Person;
import com.adev.springexample2.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping({"/persons","","/"})
    public String showPersons(Model model) {
        model.addAttribute("persons", personService.findAllPerson());
        model.addAttribute("person", new Person());
        return "PersonPage";
    }

    @PostMapping("/persons")
    public String addPerson(@ModelAttribute Person person) {
        personService.addPerson(person);
        return "redirect:/persons";
    }

    @RequestMapping(value = "/persons/{id}/delete")
    public String deletePerson(@PathVariable String id) {
        personService.deletePerson(Long.parseLong(id));
        return "redirect:/persons";
    }

    @RequestMapping("/persons/{id}")
    public String showPersonById(Model model, @PathVariable Long id) {
        model.addAttribute("persons", personService.getPersonByID(id));
        return "PersonPage";
    }
}
