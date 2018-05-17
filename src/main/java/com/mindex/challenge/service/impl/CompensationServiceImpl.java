package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * This is the compensation implementation class which contains
 * the actual implementation of the create and read method in detail.
 */

@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private CompensationRepository compensationRepository;

    /*
     * Create method to create the reading.
     */
    @Override
    public Compensation create(Compensation compensation) {
        LOG.debug("Creating compensation [{}]", compensation);

        compensationRepository.insert(compensation);

        return compensation;
    }

    /*
     * Read method which returns the number of direct reports to the particular
     * employee.
     */
    @Override
    public Compensation read(String id) {
        LOG.debug("Reading compensation of employee with id [{}]", id);

        Compensation compensation = compensationRepository.getCompensationByEmployee_EmployeeId(id);

        if (compensation == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return compensation;
    }

}
