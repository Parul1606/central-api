package com.tmdb.central_api.models;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Operation {

    UUID id;
    String name;
    String description;
}
