package ru.semenchenko.springcourse.FirstSecurityApp.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.semenchenko.springcourse.FirstSecurityApp.models.Person;
import ru.semenchenko.springcourse.FirstSecurityApp.repositories.PeopleRepository;

import java.util.Optional;

/**
 * @author Artyom Semenchenko
 */

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Optional<Person> getPersonByUsername(String username){
        return peopleRepository.findByUsername(username);
    }
}
