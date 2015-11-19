package com.yoursite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoursite.model.Person;

public interface PersonDataRepository extends JpaRepository<Person, Long> {

}
