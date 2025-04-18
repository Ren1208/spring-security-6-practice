package ru.semenchenko.springcourse.FirstSecurityApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.semenchenko.springcourse.FirstSecurityApp.models.Person;

import java.util.Optional;

/**
 * @author Artyom Semenchenko
 */

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByUsername(String username);
}