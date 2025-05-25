package com.tmdb.central_api.middleware;


import com.tmdb.central_api.dto.OperationListDto;
import com.tmdb.central_api.models.Employee;
import com.tmdb.central_api.models.Operation;
import com.tmdb.central_api.models.Organization;
import com.tmdb.central_api.models.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class DbApiIntegration {

    @Value("${db.api.base.url}")
    String baseUrl;

    public Organization callCreateOrganizationEndpoint(Organization organization){
        //this function will call/organization/create endpoint of the db api

        //step1: create endpoint
        String endpoint = baseUrl + "/organization/create";

        //step2: create a request
        RequestEntity request = RequestEntity.post(endpoint).body(organization);

        //step3: hit the request
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Organization> response = restTemplate.exchange(endpoint, HttpMethod.POST, request, Organization.class);  //when this exchange method will get called at that time we will be hitting our request to the db api
        return response.getBody();
    }

    public List<Operation> callGetAllOperationEndpoint(){
        String endPoint = baseUrl + "/operation/all";
        RequestEntity request = RequestEntity.get(endPoint).build();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<OperationListDto> resp = restTemplate.exchange(endPoint, HttpMethod.GET, request, OperationListDto.class);
        return resp.getBody().getOperationList();
    }

    public Role callSaveRoleEndpoint(Role role){
        String endpoint = baseUrl + "/role/save";
        RequestEntity request = RequestEntity.post(endpoint).body(role);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Role> resp = restTemplate.exchange(endpoint, HttpMethod.POST, request, Role.class);
        return resp.getBody();
    }

    public Employee callSaveEmployeeEndpoint(Employee employee){
        String endpoint = baseUrl + "/employee/save";
        RequestEntity request = RequestEntity.post(endpoint).body(employee);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> resp = restTemplate.exchange(endpoint, HttpMethod.POST, request, Employee.class);
        return resp.getBody();
    }
}
