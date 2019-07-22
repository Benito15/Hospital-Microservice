package com.varun.pathologyservice.resources;

import com.varun.pathologyservice.model.Disease;
import com.varun.pathologyservice.model.DiseaseList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/pathology")
public class PathologyService {
    List<Disease> diseases = Arrays.asList(
            new Disease("D1", "Asthma", "Clean air"),
            new Disease("D2", "Common Cold", "Chicken Soup"),
            new Disease("D3", "Headache", "Green Tea")
    );

    @RequestMapping("/diseases")
    private DiseaseList getDiseases() {
        DiseaseList diseaseList = new DiseaseList();
        diseaseList.setDiseases(diseases);
        return diseaseList;
    }

    @RequestMapping("/diseases/{id}")
    private Disease getDiseaseById(@PathVariable("id") String id) {
        return diseases.stream()
                .filter(disease -> disease.getId().equals(id))
                .findAny()
                .orElse(null);
    }
}
