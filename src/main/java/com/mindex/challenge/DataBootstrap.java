package com.mindex.challenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

@Component
public class DataBootstrap {
    private static final String DATASTORE_LOCATION = "/static/employee_database.json";
    private static final String COMPENSATION_DATASTORE_LOCATION = "/static/compensation_database.json";

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompensationRepository compensationRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        InputStream inputStream_employee = this.getClass().getResourceAsStream(DATASTORE_LOCATION);
        InputStream inputStream_compensation = this.getClass().getResourceAsStream(COMPENSATION_DATASTORE_LOCATION);

        Employee[] employees = null;
        Compensation compensation = null;

        try {
            employees = objectMapper.readValue(inputStream_employee, Employee[].class);
            compensation = objectMapper.readValue(inputStream_compensation, Compensation.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Employee employee : employees) {
            employeeRepository.insert(employee);
        }
        compensationRepository.insert(compensation);
    }
}
