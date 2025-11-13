package com.example.demo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {
    // PanacheRepository ya proporciona todos los métodos CRUD básicos
    // findAll(), findById(), persist(), delete(), etc.
} 