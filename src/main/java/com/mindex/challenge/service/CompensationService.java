package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;

/*
 * This is a compensation service interface and it helps in
 * creating the compensation and read the compensation
 * with the help of employee id.
 */

public interface CompensationService {

    Compensation create(Compensation compensation);
    Compensation read(String id);
}
