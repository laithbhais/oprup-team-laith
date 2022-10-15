package net.oprup.erp.controller;

import net.oprup.erp.model.SalaryObject;
import net.oprup.erp.service.SalaryObjectService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/salaryObject")
@CrossOrigin("*")
public class SalaryObjectController {

    private SalaryObjectService salaryObjectService;
    public SalaryObjectController(SalaryObjectService salaryObjectService) {
        this.salaryObjectService = salaryObjectService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<SalaryObject>> getAllSalary(){
        List<SalaryObject> salary= salaryObjectService.findAllSalaryObject();
        return new ResponseEntity<>(salary, HttpStatus.OK);
    }

    @GetMapping("/find/{salaryObjectId}")
    public ResponseEntity<SalaryObject> getSalaryBySalaryObjectId(@PathVariable("salaryObjectId") Long SalaryObjectId){
        SalaryObject salary = salaryObjectService.findSalaryObjectBySalaryObjectId(SalaryObjectId);
        return new ResponseEntity<>(salary, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<SalaryObject> addSalaryObject(@RequestBody SalaryObject salary){
        SalaryObject newSalaryObject = salaryObjectService.addSalaryObject(salary);
        return new ResponseEntity<>(newSalaryObject, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<SalaryObject> updateSalaryObject(@RequestBody  SalaryObject salary ){
        SalaryObject updateSalaryObject  = salaryObjectService.updateSalaryObject (salary);
        return new ResponseEntity<>(updateSalaryObject, HttpStatus.OK);
    }


    @PutMapping("/delete/{id}")
    public ResponseEntity<SalaryObject> deleteSalary(@PathVariable("id") SalaryObject recSalary) {
        SalaryObject deleteRecord = salaryObjectService.deleteSalaryObject(recSalary);
        return new ResponseEntity<>(deleteRecord,HttpStatus.OK);
    }



}
