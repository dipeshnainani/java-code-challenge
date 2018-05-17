package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 * The class is the rest controller for the Reporting Structure.
 * It implements create and read methods.
 *
 *  The controller makes calls to service class to execute
 *  the desired operation that is create the reporting structure
 *  and read reporting structure.
 */

@RestController
public class ReportingStructureController {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);

    @Autowired
    private ReportingStructureService reportingStructureService;

    /*
     * The method helps in creating or storing the reporting structure as
     * entered by the user. It uses post mapping to perform the operation.
     */

    @PostMapping("/reporting")
    public ReportingStructure create(@RequestBody ReportingStructure employee) {
        LOG.debug("Received employee create request for [{}]", employee);

        return reportingStructureService.create(employee);
    }

    /*
     * The method helps in returning the number of direct reports
     * which the particular employee has with the help of their
     * employee id.
     */

    @GetMapping("/reporting/{id}")
    public int read(@PathVariable String id) {
        LOG.debug("Received employee create request for id [{}]", id);

        return reportingStructureService.read(id);
    }
}
