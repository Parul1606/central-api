package com.tmdb.central_api.util;

import com.tmdb.central_api.dto.OrgDetailDto;
import com.tmdb.central_api.models.Employee;
import com.tmdb.central_api.models.Organization;
import com.tmdb.central_api.models.Role;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class MappingUtil {

    public Employee mapOrgAdminDetailsToEmployee(Organization organization, Role role){
        Employee emp = new Employee();
        emp.setCreatedAt(LocalDateTime.now());
        emp.setUpdatedAt(LocalDateTime.now());
        emp.setFirstName("System");
        emp.setLastName("Admin");
        emp.setEmail(organization.getAdminEmail());
        emp.setPassword(organization.getPassword());
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        emp.setRoles(roles);
        emp.setOrganization(organization);
        return emp;
    }

    public Organization mapOrgDetailDtoToOrganization(OrgDetailDto orgDetailDto){
        Organization organization = new Organization();
        organization.setName(orgDetailDto.getName());
        organization.setRegisteredName(orgDetailDto.getRegisteredName());
        organization.setAdminEmail(orgDetailDto.getAdminEmail());
        organization.setAdminName(orgDetailDto.getAdminName());
        organization.setPassword(orgDetailDto.getPassword());
        organization.setWebsiteUrl(orgDetailDto.getWebsiteUrl());
        organization.setAddress(orgDetailDto.getAddress());
        organization.setCompanySize(orgDetailDto.getCompanySize());
        organization.setCreatedAt(LocalDateTime.now());
        organization.setUpdatedAt(LocalDateTime.now());
        return organization;
    }
}
