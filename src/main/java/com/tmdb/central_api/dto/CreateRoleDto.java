package com.tmdb.central_api.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateRoleDto {
    String roleName;
    List<String> operations;
}
