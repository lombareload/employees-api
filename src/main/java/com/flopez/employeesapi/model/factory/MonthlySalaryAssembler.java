package com.flopez.employeesapi.model.factory;

import com.flopez.employeesapi.model.EmployeeDTO;
import com.flopez.employeesapi.model.MonthlySalaryEmployee;

import java.util.Map;

public class MonthlySalaryAssembler implements EmployeeAssembler {
    @Override
    public EmployeeDTO create(Map<String, Object> data) {
        return new MonthlySalaryEmployee(data);
    }

    private MonthlySalaryAssembler() {
    }

    public static final EmployeeAssembler INSTANCE = new MonthlySalaryAssembler();
}
