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

    @GetMapping({"/person","","/"})
    public String showPersonPage(Model model) {
        model.addAttribute("persons", personService.findAllPerson());
        model.addAttribute("person", new Person());
        return "PersonPage";
    }


    @PostMapping("/person_add")
    public String addPerson(Model model, @ModelAttribute Person person) {
        personService.addPerson(person);
        return "redirect:/person";
    }

    @RequestMapping(value = "/delete_person/{stringID}")
    public String handleDeletPerson(Model model, @PathVariable String stringID) {
        long longID = Long.parseLong(stringID);
        personService.deletePerson(longID);
        return "redirect:/person";
    }


    @RequestMapping("/personbyID/{id}")
    public String showPersonbyID(Model model, @PathVariable Long id) {
        model.addAttribute("persons", personService.getPersonByID(id));
        return "PersonPage";
    }
}
