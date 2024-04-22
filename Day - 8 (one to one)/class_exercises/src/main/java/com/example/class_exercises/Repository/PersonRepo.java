package com.example.class_exercises.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.class_exercises.Model.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

    @Query(value = "select * from Person where age=:i", nativeQuery = true)
    public List<Person> getPersonsByAge(@Param("i") int age);
}
