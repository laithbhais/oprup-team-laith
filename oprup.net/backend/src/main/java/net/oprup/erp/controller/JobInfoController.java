package net.oprup.erp.controller;
import net.oprup.erp.model.Address;
import net.oprup.erp.model.Employee;
import net.oprup.erp.model.EmployeeBank;
import net.oprup.erp.model.JobInfo;
import net.oprup.erp.service.AddressService;

import net.oprup.erp.service.JobInfoService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/jobInfo")
@CrossOrigin("*")


public class JobInfoController {

    private JobInfoService jobInfoService;

    public JobInfoController(JobInfoService jobInfoService) {
        this.jobInfoService = jobInfoService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<JobInfo>> getAllJobInfo(){
        List<JobInfo> jobInfo=jobInfoService.findAllJobInfo();
        return new ResponseEntity<>(jobInfo, HttpStatus.OK);
    }



    @GetMapping("/find/{employeeId}")
    public ResponseEntity<?> getJobInfoByEmployeeId(@PathVariable("employeeId") Long employeeId){
        Employee emp = new Employee();
        emp.setEmployeeId(employeeId);
        List<JobInfo> jobInfo = jobInfoService.getJobInfoByEmployeeId(emp);
        return new ResponseEntity<>(jobInfo, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<JobInfo> addJobInfo(@RequestBody JobInfo jobInfo){
        JobInfo newJobInfo = jobInfoService.addJobInfo(jobInfo);
        return new ResponseEntity<>(newJobInfo, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<JobInfo> updateJobInfo(@RequestBody JobInfo jobInfo ){
        JobInfo updateJobInfo = jobInfoService.updateJobInfo(jobInfo);
        return new ResponseEntity<>(updateJobInfo, HttpStatus.OK);
    }


    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteJobInfo(@PathVariable("id") JobInfo id) {
        jobInfoService.deleteJobInfo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
