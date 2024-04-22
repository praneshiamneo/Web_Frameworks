package com.example.class_exercises.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.class_exercises.Model.Person;
import com.example.class_exercises.Repository.PersonRepo;

import jakarta.transaction.Transactional;

@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    @Transactional
    public Person creatPerson(Person person) {
        return personRepo.save(person);
    }

    public List<Person> getAllPersons() {
        return personRepo.findAll();
    }

    public List<Person> getPersonsByAge(int age) {
        return personRepo.getPersonsByAge(age);
    }

    public Optional<Person> getPersonById(int id) {
        return personRepo.findById(id);
    }
}
