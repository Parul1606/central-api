package com.tmdb.central_api.service;

import com.tmdb.central_api.dto.LoginDto;
import com.tmdb.central_api.dto.UserDetailDto;
import com.tmdb.central_api.exceptions.WrongCredentialsException;
import com.tmdb.central_api.middleware.AuthApiConnector;
import com.tmdb.central_api.middleware.DbApiIntegration;
import com.tmdb.central_api.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    DbApiIntegration dbApiIntegration;

    @Autowired
    AuthApiConnector authApiConnector;

    public Employee saveEmployeeToDb(Employee employee){
        return dbApiIntegration.callSaveEmployeeEndpoint(employee);
    }

    public Employee getEmployeeByEmail(String email){
        return dbApiIntegration.callGetEmployeeByEmailEndpoint(email);
    }

    public String loginEmployee(LoginDto loginDetails){
        String email = loginDetails.getEmail();
        String password = loginDetails.getPassword();
        Employee employee = this.getEmployeeByEmail(email);
        if(employee == null){
            throw new WrongCredentialsException("wrong email entered");
        }
        if(employee.getPassword().equals(password)){
            //we will generate token
            //central api is going to call auth api connector class
            //and auth api connector class will hit the auth api generate token endpoint & will bring that token to us.
            UserDetailDto userDetailDto = new UserDetailDto();
            userDetailDto.setEmail(employee.getEmail());
            userDetailDto.setPassword(employee.getPassword());
            userDetailDto.setRole(employee.getRoles().get(0).getName());
            String token = authApiConnector.callGetJwtTokenEndpoint(userDetailDto);
            return token;
        }
        throw new WrongCredentialsException("Wrong password entered");
    }
}