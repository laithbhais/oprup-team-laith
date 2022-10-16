package net.oprup.erp.controller;
import net.oprup.erp.model.Experience;
import net.oprup.erp.model.Employee;
import net.oprup.erp.service.ExperienceService;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/experience")
@CrossOrigin("*")

public class ExperienceController {

    private ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Experience>> getAllExperience(){
        List<Experience> experience=experienceService.findAllExperience();
        return new ResponseEntity<>(experience, HttpStatus.OK);
    }

    @GetMapping("/find/{employeeId}")
    public ResponseEntity<?> getExperienceByEmployeeId(@PathVariable("employeeId") Long employeeId){
        Employee emp = new Employee();
        emp.setEmployeeId(employeeId);
        List<Experience> employeeExperience = experienceService.getExperienceByEmployeeId(emp);
        return new ResponseEntity<>(employeeExperience, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<Experience> addExperience(@RequestBody Experience experience){
        Experience newExperience = experienceService.addExperience(experience);
        return new ResponseEntity<>(newExperience, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Experience> updateExperience(@RequestBody Experience experience ){
        Experience updateExperience = experienceService.updateExperience(experience);
        return new ResponseEntity<>(updateExperience, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteExperience(@PathVariable("id") Experience id) {
        experienceService.deleteExperience(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
