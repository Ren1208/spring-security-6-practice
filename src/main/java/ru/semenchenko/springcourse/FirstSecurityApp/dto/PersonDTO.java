package ru.semenchenko.springcourse.FirstSecurityApp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 * @author Artyom Semenchenko
 */

public class PersonDTO {

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 100, message = "Длина имени должна быть от 2 до 100 символов")
    private String username;

    @Min(value = 1900, message = "Год рождения должен быть больше 1900")
    @Max(value = 2025, message = "Некорретный год рождения")
    private int yearOfBirth;

    @NotEmpty(message = "Пароль не может быть пустым")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
