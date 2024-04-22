package com.example.class_exercise2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.class_exercise2.Model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
