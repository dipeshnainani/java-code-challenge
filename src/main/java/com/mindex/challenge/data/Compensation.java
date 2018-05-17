package com.mindex.challenge.data;

/*
 * Compensation data class which implements getter and
 * setter methods for the components of Compensation.
 *
 * It can also be called as an entity class.
 */
public class Compensation {

    private Employee employee;
    private String salary;
    private String effectiveData;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEffectiveData() {
        return effectiveData;
    }

    public void setEffectiveData(String effectiveData) {
        this.effectiveData = effectiveData;
    }
}
