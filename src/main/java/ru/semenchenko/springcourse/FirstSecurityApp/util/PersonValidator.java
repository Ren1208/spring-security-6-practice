package ru.semenchenko.springcourse.FirstSecurityApp.util;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.semenchenko.springcourse.FirstSecurityApp.models.Person;
import ru.semenchenko.springcourse.FirstSecurityApp.services.PeopleService;
import ru.semenchenko.springcourse.FirstSecurityApp.services.PersonDetailsService;

/**
 * @author Artyom Semenchenko
 */

@Component
public class PersonValidator implements Validator {

    private final PeopleService peopleService;

    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        if (peopleService.getPersonByUsername(person.getUsername()).isPresent())
            errors.rejectValue("username", "",
                    "Человек с таким именем пользователя уже существует.");
    }
}
