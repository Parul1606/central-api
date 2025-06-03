package com.tmdb.central_api.service;

import com.tmdb.central_api.dto.OrgDetailDto;
import com.tmdb.central_api.middleware.DbApiIntegration;
import com.tmdb.central_api.middleware.NotificationAPIConnector;
import com.tmdb.central_api.models.Employee;
import com.tmdb.central_api.models.Organization;
import com.tmdb.central_api.models.Role;
import com.tmdb.central_api.util.MappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OrgService {

    @Autowired
    DbApiIntegration dbApiIntegration;

    @Autowired
    NotificationAPIConnector notificationAPIConnector;

    @Autowired
    MappingUtil mapper;

    @Autowired
    RoleService roleService;

    @Autowired
    EmployeeService employeeService;

    public Object createOrganization(OrgDetailDto orgDetailDto){
        //OrgDetailDto
        //we need to map these details to actual organization model object.
        Organization organization = mapper.mapOrgDetailDtoToOrganization(orgDetailDto);

        // we need to call database-api create organization endpoint
        // that endpoint will save organization details in database.
        Organization org = dbApiIntegration.callCreateOrganizationEndpoint(organization);

        //when org will get created then we should create default admin role for the org
        Role role = roleService.createDefaultAdminRole(org);

        //when role got created inside the system lets create the first employee of organization that is systemAdmin
        Employee employee = mapper.mapOrgAdminDetailsToEmployee(org, role);
        employee = employeeService.saveEmployeeToDb(employee);

        notificationAPIConnector.callOrgCreateNotificationEndpoint(organization);
        return org;
    }
}
