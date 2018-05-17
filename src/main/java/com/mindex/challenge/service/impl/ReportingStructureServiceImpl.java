package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.ReportingStructureRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        HashMap<String, List<Employee>> flowOfReports = new HashMap<>();
        List<Employee> reports = reportingStructure.getDirectReports();
        int count = 0, i = reports.size(), k = 0;

        // hashmap to record the flow of direct reports
        flowOfReports.put(reportingStructure.getEmployeeId(), reports);

        if(reports == null) {
            System.out.println(reportingStructure.getEmployeeId() + " has no direct reports.");
            return 0;
        }

        // helps in computing the number of direct reports and the flow of direct reports to the employee
        while(k < i) {
            ReportingStructure structures = reportingStructureRepository.getReportingStructuresByEmployeeId(reports.get(k).getEmployeeId());
            List<Employee> listOfStructures = structures.getDirectReports();
            flowOfReports.put(structures.getEmployeeId(),listOfStructures);

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

        System.out.println("Flow of Direct Reports");
        // printing the flow of reports
        for(String key: flowOfReports.keySet()){
            List<Employee> listDirectReports = flowOfReports.get(key);

            System.out.print(key + " direct reports ");

            if(listDirectReports == null) {
                System.out.print(listDirectReports);
            }  else {
                for (int value = 0 ; value < listDirectReports.size() ; value ++) {
                    System.out.print(listDirectReports.get(value).getEmployeeId()+ " ");
                }
            }

            System.out.println();
        }

        System.out.println("Number of direct reports to " + id + " is " + count);
        return count;

    }

}
