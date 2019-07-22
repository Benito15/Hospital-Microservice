package com.varun.admissionsservice.model;

import java.util.List;

public class EmployeesList {
    public List<Employee> employees;

    public EmployeesList () {
    }

    public List<Employee> getEmployees () {
        return employees;
    }

    public void setEmployees (List<Employee> employees) {
        this.employees = employees;
    }
}
