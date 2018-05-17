package com.mindex.challenge.data;

import java.util.List;

/*
 * Reporting Structure data class which implements getter and
 * setter methods for the components of Reporting Structure.
 *
 * It can also be called as an entity class.
 */

public class ReportingStructure {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String position;
    private String department;
    private List<Employee> directReports;
    private String numberOfReports;

    public ReportingStructure() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Employee> getDirectReports() {
        return directReports;
    }

    public void setDirectReports(List<Employee> directReports) {
        this.directReports = directReports;
    }

    public String getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(String numberOfReports) {
        this.numberOfReports = numberOfReports;
    }
}
