package com.varun.admissionsservice.resources;

import com.varun.admissionsservice.model.Patient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admissions")
public class AdmissionsResource {

    List<Patient> patients = Arrays.asList(
            new Patient("P1", "Tony Stark", "American"),
            new Patient("P2", "Sherlock Holmes", "Britisher"),
            new Patient("P3", "James Bond", "Britisher")
    );

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
