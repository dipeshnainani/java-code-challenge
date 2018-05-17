package com.mindex.challenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.dao.ReportingStructureRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

/*
 * Class which contains object mappers to insert the values in the particular
 * database.
 */

@Component
public class DataBootstrap {
    private static final String DATASTORE_LOCATION = "/static/employee_database.json";
    private static final String COMPENSATION_DATASTORE_LOCATION = "/static/compensation_database.json";
    private static final String REPORTING_DATABASE_LOCATION = "/static/reporting_database.json";

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompensationRepository compensationRepository;

    @Autowired
    private ReportingStructureRepository reportingStructureRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        InputStream inputStream_employee = this.getClass().getResourceAsStream(DATASTORE_LOCATION);
        InputStream inputStream_compensation = this.getClass().getResourceAsStream(COMPENSATION_DATASTORE_LOCATION);
        InputStream inputStream_reporting_structure = this.getClass().getResourceAsStream(REPORTING_DATABASE_LOCATION);

        Employee[] employees = null;
        Compensation compensation = null;
        ReportingStructure[] reportingStructures = null;

        try {
            employees = objectMapper.readValue(inputStream_employee, Employee[].class);
            compensation = objectMapper.readValue(inputStream_compensation, Compensation.class);
            reportingStructures = objectMapper.readValue(inputStream_reporting_structure, ReportingStructure[].class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Employee employee : employees) {
            employeeRepository.insert(employee);
        }
        compensationRepository.insert(compensation);

        for (ReportingStructure reportingStructure : reportingStructures) {
            reportingStructureRepository.insert(reportingStructure);
        }

    }
}
