package com.example.hibernate.service;

import com.example.hibernate.entity.Person;
import com.example.hibernate.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Service {
    private final Repository repository;


    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<Person> findByCityOfLiving(String city){
        return repository.findByCityOfLiving(city);
    }

    public Optional<Person> findByPersonIdNameAndAndPersonIdSurname(String name, String surname){
        return repository.findByPersonIdNameAndAndPersonIdSurname(name,surname);
    }

    public List<Person> findByPersonIdAge(int age){
        return repository.findByPersonIdAge(age);
    }

}


