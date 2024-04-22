package com.example.class_exercise2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.class_exercise2.Model.Address;
import com.example.class_exercise2.Model.Person;
import com.example.class_exercise2.Services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/persons")
    public Person addPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @PostMapping("/persons/{personId}/addresses")
    public Address addAddressToPerson(@PathVariable Long personId, @RequestBody Address address) {
        Person person = personService.getPersonById(personId);
        address.setPerson(person);
        return personService.saveAddress(address);
    }

    @GetMapping("/persons/{personId}/addresses")
    public List<Address> getAddressesOfPerson(@PathVariable Long personId) {
        Person person = personService.getPersonById(personId);
        return person.getAddresses();
    }
}
