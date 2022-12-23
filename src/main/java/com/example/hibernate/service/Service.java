package com.example.hibernate.service;

import com.example.hibernate.entity.Person;
import com.example.hibernate.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Service {
    private final Repository repository;


    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }
}
