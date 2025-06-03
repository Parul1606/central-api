package com.tmdb.central_api.controller;

import com.tmdb.central_api.dto.CreateRoleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/central/role")
public class RoleController {

    @PostMapping("/create")
    public ResponseEntity createRole(@RequestBody CreateRoleDto roleDetails,
                                     @RequestHeader String Authorization){

    }
}
