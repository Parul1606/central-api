package com.tmdb.central_api.service;

import com.tmdb.central_api.middleware.DbApiIntegration;
import com.tmdb.central_api.models.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {

    @Autowired
    DbApiIntegration dbApiIntegration;

    public List<Operation> getAllOperations(){
        return dbApiIntegration.callGetAllOperationEndpoint();
    }
}
