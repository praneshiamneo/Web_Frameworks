package com.example.class_exercises.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.class_exercises.Model.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {

}
