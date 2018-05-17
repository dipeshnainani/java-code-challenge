package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 * The class is the rest controller for the Compensation.
 * It implements create and read methods as asked to be
 *  implemented in the Task 2.
 *
 *  The controller makes calls to service class to execute
 *  the desired operation that is create the compensation
 *  and read the compensation.
 */

@RestController
public class CompensationController {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    CompensationService compensationService;

    /*
     * The method helps in creating or storing the compensation as
     * entered by the user. It uses post mapping to perform the operation.
     */

    @PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation compensation) {
        LOG.debug("Received compensation create request for [{}]", compensation);

        return compensationService.create(compensation);
    }

    /*
     * The method helps in getting or reading the compensation reading
     * with the help of id as entered by the user. It uses get mapping
     * to perform the operation and takes in the id from the path
     * entered by user.
     *
     * Example: localhost:8080/employee/16a596ae-edd3-4847-99fe-c4518e82c86f
     *
     * id is : 16a596ae-edd3-4847-99fe-c4518e82c86f
     */
    @GetMapping("/compensation/{id}")
    public Compensation read(@PathVariable String id) {
        LOG.debug("Received compensation read request for id [{}]", id);

        return compensationService.read(id);
    }
}
