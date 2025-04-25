package ru.semenchenko.springcourse.FirstSecurityApp.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.semenchenko.springcourse.FirstSecurityApp.models.Person;
import ru.semenchenko.springcourse.FirstSecurityApp.repositories.PeopleRepository;

/**
 * @author Artyom Semenchenko
 */

@Service
@Transactional(readOnly = true)
public class RegistrationService {

    private final PeopleRepository peopleRepository;

    public RegistrationService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Transactional
    public void register(Person person) {
        peopleRepository.save(person);
    }
}
