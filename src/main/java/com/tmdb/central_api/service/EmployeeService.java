package com.tmdb.central_api.service;

import com.tmdb.central_api.middleware.DbApiIntegration;
import com.tmdb.central_api.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    DbApiIntegration dbApiIntegration;

    public Employee saveEmployeeToDb(Employee employee){
        return dbApiIntegration.callSaveEmployeeEndpoint(employee);
    }
}
