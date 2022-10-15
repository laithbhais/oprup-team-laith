package net.oprup.erp.controller;
import net.oprup.erp.model.JobTitle;
import net.oprup.erp.service.JobTitleService;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/jobTitle")
@CrossOrigin("*")

public class JobTitleController {

    private JobTitleService jobTitleService;

    public JobTitleController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<JobTitle>> getAllJobTitle(){
        List<JobTitle> jobTitle=jobTitleService.findAllJobTitle();
        return new ResponseEntity<>(jobTitle, HttpStatus.OK);
    }

    @GetMapping("/find/{jobTitleId}")
    public ResponseEntity<JobTitle> getJobTitleById(@PathVariable("jobTitleId") Long jobTitleId){
        JobTitle jobTitle = jobTitleService.findJobTitleByJobTitleId(jobTitleId);
        return new ResponseEntity<>(jobTitle, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<JobTitle> addJobTitle(@RequestBody JobTitle jobTitle){
        JobTitle newJobTitle = jobTitleService.addJobTitle(jobTitle);
        return new ResponseEntity<>(newJobTitle, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<JobTitle> updateJobTitle(@RequestBody JobTitle jobTitle ){
        JobTitle updateJobTitle = jobTitleService.updateJobTitle(jobTitle);
        return new ResponseEntity<>(updateJobTitle, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteJobTitle(@PathVariable("id") JobTitle id) {
        jobTitleService.deleteJobTitle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
