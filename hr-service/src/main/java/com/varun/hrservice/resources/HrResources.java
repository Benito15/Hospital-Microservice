package com.varun.hrservice.resources;

import com.varun.hrservice.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/hr")
public class HrResources {

    List<Employee> employees = Arrays.asList(
            new Employee("E1", "Kindson", "Hulo", "MediTech"),
            new Employee("E2", "Lynda", "Queen", "Surgery"),
            new Employee("E3", "Maroon", "Samuels", "Dentistry")
    );

    @RequestMapping("/employees")
    public List<Employee> getEmployees() {
        return employees;
    }

    @RequestMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") String id) {
        return employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findAny()
                .orElse(null);
    }
}
