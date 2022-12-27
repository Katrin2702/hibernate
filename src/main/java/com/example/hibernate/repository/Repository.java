package com.example.hibernate.repository;

import com.example.hibernate.entity.Person;
import com.example.hibernate.entity.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Repository extends JpaRepository<Person, PersonId> {

    List<Person> findByCityOfLiving(String city);

    Optional<Person> findByPersonIdNameAndAndPersonIdSurname(String name, String surname);

    List<Person> findByPersonIdAge(int age);

}
