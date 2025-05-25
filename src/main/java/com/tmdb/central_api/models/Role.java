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
public class Role {

    UUID id;
    String name;
    Organization organization;
    List<Operation> operations;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
