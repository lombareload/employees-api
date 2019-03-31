package com.flopez.employeesapi.model;

import java.util.Map;

public class HourlySalaryEmployee extends EmployeeDTO {
    public HourlySalaryEmployee(Map<String, Object> data) {
        super(data);
    }

    @Override
    public Double getAnnualSalary() {
        return getHourlySalary() * 12 * 120;
    }
}
