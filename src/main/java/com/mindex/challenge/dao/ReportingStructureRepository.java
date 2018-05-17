package com.mindex.challenge.dao;

import com.mindex.challenge.data.ReportingStructure;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
 * Repository interface which helps in getting the employee by employee id
 * and getting the employee who reports to a particular employee with the help
 * of the particular employee's id.
 */
@Repository
public interface ReportingStructureRepository extends MongoRepository<ReportingStructure, String> {
    ReportingStructure findByEmployeeId(String employeeId);

    ReportingStructure getReportingStructuresByEmployeeId(String employeeId);
}
