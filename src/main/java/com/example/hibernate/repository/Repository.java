package com.example.hibernate.repository;

import com.example.hibernate.entity.Person;
import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@org.springframework.stereotype.Repository
public class Repository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        var query = entityManager.createQuery("select p from Person p where p.cityOfLiving = :city",
                Person.class);
        query.setParameter("city_of_living", city);
        return query.getResultList();
    }

    @Transactional
    public List<Person> savePersons() {
        Random random = new Random();

        var names = Arrays.asList("Andrey", "Mike", "Sergey", "Ivan", "Arseniy");
        var surnames = Arrays.asList("Sidorov", "Sukhanov", "Demin", "Phedorov", "Tikhonov");
        var cities = Arrays.asList("Moscow", "Saint-Petersburg", "Ekaterinburg");

        IntStream.range(0, 100)
                .forEach(i -> {
                    var person = Person.builder()
                            .name(names.get(random.nextInt(names.size())))
                            .surname(surnames.get(random.nextInt(surnames.size())))
                            .age(random.nextInt(100))
                            .cityOfLiving(cities.get(random.nextInt(cities.size())))
                            .phoneNumber("+79" + random.nextInt(999999999))
                            .build();

                    this.entityManager.persist(person);

                });

        var query = entityManager.createQuery("select p from Person p", Person.class);
        return query.getResultList();
    }

}
