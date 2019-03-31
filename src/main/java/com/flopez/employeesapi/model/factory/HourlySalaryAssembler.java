package com.flopez.employeesapi.model.factory;

import com.flopez.employeesapi.model.EmployeeDTO;
import com.flopez.employeesapi.model.HourlySalaryEmployee;

import java.util.Map;

public class HourlySalaryAssembler implements EmployeeAssembler {
    @Override
    public EmployeeDTO create(Map<String, Object> data) {
        return new HourlySalaryEmployee(data);
    }

    private HourlySalaryAssembler() {
    }

    public static final EmployeeAssembler INSTANCE = new HourlySalaryAssembler();
}
