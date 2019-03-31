package com.flopez.employeesapi.web;

import com.flopez.employeesapi.model.EmployeeDTO;
import com.flopez.employeesapi.service.EmployeeDataRetriever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
    @Autowired
    private EmployeeDataRetriever dataRetriever;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.of(dataRetriever.getById(id));
    }

    @GetMapping
    public List<EmployeeDTO> getAll() {
        return dataRetriever.getAll();
    }
}
