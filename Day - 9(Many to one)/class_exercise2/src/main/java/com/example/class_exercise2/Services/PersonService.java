package com.example.class_exercise2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.class_exercise2.Model.Address;
import com.example.class_exercise2.Model.Person;
import com.example.class_exercise2.Repository.AddressRepository;
import com.example.class_exercise2.Repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Person getPersonById(Long personId) {
        Optional<Person> personOptional = personRepository.findById(personId);
        return personOptional.orElse(null);
    }
}