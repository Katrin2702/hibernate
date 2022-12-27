package com.example.hibernate.controller;

import com.example.hibernate.entity.Person;
import com.example.hibernate.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getNameByCity(@RequestParam("city") String city) {
        return service.findByCityOfLiving(city);
    }

    @GetMapping("/persons/by-person")
    public Optional<Person> getPersonByNameAndSurname(@RequestParam("name") String name,
                                                      @RequestParam("surname") String surname) {
        return service.findByPersonIdNameAndAndPersonIdSurname(name, surname);
    }


    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByAge(@RequestParam("age") int age) {
        return service.findByPersonIdAge(age);
    }

}
