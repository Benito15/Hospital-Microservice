package com.varun.admissionsservice.resources;

import com.varun.admissionsservice.model.EmployeesList;
import com.varun.admissionsservice.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admissions")
public class AdmissionsResource {

    @Autowired
    private RestTemplate restTemplate;

    List<Patient> patients = Arrays.asList(
            new Patient("P1", "Tony Stark", "American"),
            new Patient("P2", "Sherlock Holmes", "Britisher"),
            new Patient("P3", "James Bond", "Britisher")
    );

    @RequestMapping("/physicians")
    public EmployeesList getPhysicians () {
        EmployeesList employeesList =
                restTemplate.getForObject("http://localhost:8082/hr/employees", EmployeesList.class);
        return employeesList;
    }

    @RequestMapping("/patients")
    public List<Patient> getPatients() {
        return patients;
    }

    @RequestMapping("/patients/{Id}")
    public Patient getPatientById (@PathVariable("Id") String Id) {
        return patients.stream()
                .filter(patient -> patient.getId().equals(Id))
                .findAny()
                .orElse(null);
    }
}
