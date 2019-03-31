package com.flopez.employeesapi.model;

import java.util.Map;

public class MonthlySalaryEmployee extends EmployeeDTO {
    public MonthlySalaryEmployee(Map<String, Object> data) {
        super(data);
    }

    @Override
    public Double getAnnualSalary() {
        return getMonthlySalary() * 12;
    }
}
