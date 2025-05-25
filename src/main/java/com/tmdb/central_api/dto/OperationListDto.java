package com.tmdb.central_api.dto;

import com.tmdb.central_api.models.Operation;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OperationListDto {
    List<Operation> operationList;
}