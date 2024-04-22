package com.example.class_exercises.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.class_exercises.Model.Address;
import com.example.class_exercises.Repository.AddressRepo;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressRepo addressRepo;

    @PostMapping("/addAddress")
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
        Address adrs = addressRepo.save(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(adrs);
    }

    @GetMapping("/retriveAddress")
    public ResponseEntity<List<Address>> getAddress() {
        List<Address> getAdrs = addressRepo.findAll();
        return ResponseEntity.ok(getAdrs);
    }
}
