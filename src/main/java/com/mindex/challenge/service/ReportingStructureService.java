package com.mindex.challenge.service;

import com.mindex.challenge.data.ReportingStructure;

/*
 * This is a reporting structure interface. These are called
 * by the controller class when the user requests for the
 * particular operation.
 *
 * It uses create method to create the
 * reporting structure reading and read method to return
 * the number of direct reports which the employee has.
 */

public interface ReportingStructureService {
    ReportingStructure create(ReportingStructure reportingStructure);
    int read(String id);
}
