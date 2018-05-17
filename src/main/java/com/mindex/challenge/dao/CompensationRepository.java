package com.mindex.challenge.dao;

import com.mindex.challenge.data.Compensation;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
 * Repository interface which helps in getting the reading of
 * compensation by employee id.
 */

@Repository
public interface CompensationRepository extends MongoRepository<Compensation, String> {

    Compensation getCompensationByEmployee_EmployeeId(String employeeId);
}
