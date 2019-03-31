package com.flopez.employeesapi.model.factory;

import com.flopez.employeesapi.model.EmployeeDTO;

import java.util.Map;

public interface EmployeeAssembler {
    EmployeeDTO create(Map<String, Object> data);
}
