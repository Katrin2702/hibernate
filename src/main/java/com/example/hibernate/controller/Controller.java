package com.example.hibernate.controller;

import com.example.hibernate.entity.Person;
import com.example.hibernate.service.Service;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/persons/by-city")
    @Secured("ROLE_READ")
    public List<Person> getNameByCity(@RequestParam("city") String city) {
        return service.findByCityOfLiving(city);
    }

    @GetMapping("/persons/by-person")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public Optional<Person> getPersonByNameAndSurname(@RequestParam("name") String name,
                                                      @RequestParam("surname") String surname) {
        return service.findByPersonIdNameAndAndPersonIdSurname(name, surname);
    }

    @GetMapping("/persons/by-age")
    @RolesAllowed("ROLE_WRITE")
    public List<Person> getPersonsByAge(@RequestParam("age") int age) {
        return service.findByPersonIdAge(age);
    }

    @GetMapping("/username")
        @PreAuthorize("#username == authentication.principal.username")
    public String login (String username) {
        return username + ", you got access";
    }
}
