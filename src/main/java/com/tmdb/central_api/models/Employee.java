package com.tmdb.central_api.models;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    UUID id;
    String firstName;
    String lastName;
    String email;
    String password;
    Organization organization;
    List<Role> roles;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
