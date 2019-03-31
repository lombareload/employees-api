package com.flopez.employeesapi.service;

import com.flopez.employeesapi.model.EmployeeDTO;
import com.flopez.employeesapi.model.factory.EmployeeAssembler;
import com.flopez.employeesapi.model.factory.HourlySalaryAssembler;
import com.flopez.employeesapi.model.factory.MonthlySalaryAssembler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class EmployeeDataRetriever {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDataRetriever.class);

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${employees.endpoint}")
    private String url;

    private Map<Integer, EmployeeDTO> repository;

    @PostConstruct
    private void HitApi() {
        final ParameterizedTypeReference<List<Map>> mapListReference = new ParameterizedTypeReference<List<Map>>() {};
        final RestTemplate restTemplate = restTemplateBuilder.build();
        final ResponseEntity<List<Map>> response = restTemplate.exchange(url, HttpMethod.GET, null, mapListReference);
        final List<Map> body = response.getBody();

        final EmployeeAssembler HOURLY_ASSEMBLER = HourlySalaryAssembler.INSTANCE;
        final EmployeeAssembler MONTHLY_ASSEMBLER = MonthlySalaryAssembler.INSTANCE;

        repository = body.stream()
                .map(data -> {
                    final String contractTypeName = (String) data.get("contractTypeName");
                    switch (contractTypeName) {
                        case "HourlySalaryEmployee":
                            return HOURLY_ASSEMBLER.create(data);
                        case "MonthlySalaryEmployee":
                            return MONTHLY_ASSEMBLER.create(data);
                        default:
                            LOGGER.warn("Unknown contractTypeName ({}) ignoring entry", contractTypeName);
                            return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(EmployeeDTO::getId, Function.identity()));
    }

    public Optional<EmployeeDTO> getById(Integer id) {
        return Optional.ofNullable(repository.get(id));
    }

    public List<EmployeeDTO> getAll() {
        return new ArrayList<>(repository.values());
    }
}
