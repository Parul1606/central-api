package com.tmdb.central_api.service;

import com.tmdb.central_api.middleware.DbApiIntegration;
import com.tmdb.central_api.models.Operation;
import com.tmdb.central_api.models.Organization;
import com.tmdb.central_api.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class RoleService {

    @Autowired
    OperationService operationService;

    @Autowired
    DbApiIntegration dbApiIntegration;

    public Role createDefaultAdminRole(Organization organization){
        Role role = new Role();
        role.setCreatedAt(LocalDateTime.now());
        role.setUpdatedAt(LocalDateTime.now());
        role.setName("org-admin");
        role.setOrganization(organization);
        List<Operation> oprs = operationService.getAllOperations();
        role.setOperations(oprs);
        return this.saveRoleToDb(role);
    }

    public Role saveRoleToDb(Role role){
        return dbApiIntegration.callSaveRoleEndpoint(role);
    }
}
