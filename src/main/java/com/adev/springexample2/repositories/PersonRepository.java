package com.adev.springexample2.repositories;

import com.adev.springexample2.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long>{
}
