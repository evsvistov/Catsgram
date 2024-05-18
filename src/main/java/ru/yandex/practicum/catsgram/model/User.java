package ru.yandex.practicum.catsgram.model;

import lombok.*;

import java.time.Instant;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Instant registrationDate;

}
