package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.ReportingStructureRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/*
 * This is the reporting service implementation class which contains
 * the actual implementation of the create and read method in detail.
 */

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService{
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private ReportingStructureRepository reportingStructureRepository;

    /*
     * Create method to create the reading.
     */
    @Override
    public ReportingStructure create(ReportingStructure reportingStructure) {
        LOG.debug("Creating reporting structure [{}]", reportingStructure);

        reportingStructure.setNumberOfReports(String.valueOf(reportingStructure.getDirectReports().size()));
        reportingStructureRepository.insert(reportingStructure);

        return reportingStructure;
    }

    /*
     * Read method which returns the number of direct reports to the particular
     * employee.
     */
    @Override
    public int read(String id) {
        LOG.debug("Reading compensation of employee with id [{}]", id);

        ReportingStructure reportingStructure = reportingStructureRepository.findByEmployeeId(id);

        if (reportingStructure == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        List<Employee> reports = reportingStructure.getDirectReports();
        int count = 0, i = reports.size(), k = 0;

        if(reports == null) {
            return 0;
        }

        while(k < i) {
            ReportingStructure structures = reportingStructureRepository.getReportingStructuresByEmployeeId(reports.get(k).getEmployeeId());
            System.out.println(structures.getEmployeeId() + "   " + structures.getDirectReports());
            List<Employee> listOfStructures = structures.getDirectReports();

            if(listOfStructures == null) {
                count = count + 1;
                k = k + 1;
            } else {
                count = count + 1;
                k = k + 1;
                i = i + listOfStructures.size();
                reports.addAll(listOfStructures);
            }
        }

        return count;

    }

}
