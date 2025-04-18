package ru.semenchenko.springcourse.FirstSecurityApp.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.semenchenko.springcourse.FirstSecurityApp.models.Person;
import ru.semenchenko.springcourse.FirstSecurityApp.repositories.PeopleRepository;
import ru.semenchenko.springcourse.FirstSecurityApp.security.PersonDetails;

/**
 * @author Artyom Semenchenko
 */

@Service
public class PersonDetailsService implements UserDetailsService {

    private final PeopleRepository peopleRepository;

    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = peopleRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));

        return new PersonDetails(person);
    }
}