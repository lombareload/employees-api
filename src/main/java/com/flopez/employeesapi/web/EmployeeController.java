package com.flopez.employeesapi.web;


import com.flopez.employeesapi.service.EmployeeDataRetriever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/html/employees")
public class EmployeeController {
    @Autowired
    private EmployeeDataRetriever employeeDataRetriever;

    @GetMapping
    public String getById(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> model) {
        if (id == null) {
            model.put("employees", employeeDataRetriever.getAll());
            return "employees";
        } else {
            model.put("employee", employeeDataRetriever.getById(id).orElse(null));
            return "employee";
        }
    }
}
