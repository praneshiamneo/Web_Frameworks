package com.example.class_exercises.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.class_exercises.Model.Person;
import com.example.class_exercises.Service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/add")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person createdPerson = personService.creatPerson(person);
        if (createdPerson != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/retrive")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.getAllPersons();
        if (persons != null) {
            return ResponseEntity.ok(persons);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/byAge")
    public ResponseEntity<List<Person>> getPersonsByAge(@RequestParam("age") int age) {
        List<Person> persons = personService.getPersonsByAge(age);
        if (persons != null) {
            return ResponseEntity.ok(persons);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("byId/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") int id) {
        return personService.getPersonById(id)
                .map(person -> new ResponseEntity<>(person, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
