package com.example.class_exercise2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.class_exercise2.Model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
