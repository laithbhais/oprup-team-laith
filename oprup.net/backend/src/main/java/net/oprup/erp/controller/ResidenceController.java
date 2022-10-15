package net.oprup.erp.controller;
import net.oprup.erp.model.Residence;
import net.oprup.erp.model.Employee;
import net.oprup.erp.service.ResidenceService;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/residence")
@CrossOrigin("*")

public class ResidenceController {

    private ResidenceService residenceService;

    public ResidenceController(ResidenceService residenceService) {
        this.residenceService = residenceService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Residence>> getAllResidence(){
        List<Residence> residence=residenceService.findAllResidence();
        return new ResponseEntity<>(residence, HttpStatus.OK);
    }

    @GetMapping("/find/{employeeId}")
    public ResponseEntity<?> getResidenceByEmployeeId(@PathVariable("employeeId") Long employeeId){
        Employee emp = new Employee();
        emp.setEmployeeId(employeeId);
        List<Residence> employeeResidence = residenceService.getResidenceByEmployeeId(emp);
        return new ResponseEntity<>(employeeResidence, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<Residence> addResidence(@RequestBody Residence residence){
        Residence newResidence = residenceService.addResidence(residence);
        return new ResponseEntity<>(newResidence, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Residence> updateResidence(@RequestBody Residence residence ){
        Residence updateResidence = residenceService.updateResidence(residence);
        return new ResponseEntity<>(updateResidence, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteResidence(@PathVariable("id") Residence id) {
        residenceService.deleteResidence(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
