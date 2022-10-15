package net.oprup.erp.controller;
import net.oprup.erp.model.Visa;
import net.oprup.erp.model.Employee;
import net.oprup.erp.model.EmployeeBank;
import net.oprup.erp.service.VisaService;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/visa")
@CrossOrigin("*")

public class VisaController {

    private VisaService visaService;

    public VisaController(VisaService visaService) {
        this.visaService = visaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Visa>> getAllVisa(){
        List<Visa> visa=visaService.findAllVisa();
        return new ResponseEntity<>(visa, HttpStatus.OK);
    }

    @GetMapping("/find/{employeeId}")
    public ResponseEntity<?> getVisaByEmployeeId(@PathVariable("employeeId") Long employeeId){
        Employee emp = new Employee();
        emp.setEmployeeId(employeeId);
        List<Visa> employeeVisa = visaService.getVisaByEmployeeId(emp);
        return new ResponseEntity<>(employeeVisa, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<Visa> addVisa(@RequestBody Visa visa){
        Visa newVisa = visaService.addVisa(visa);
        return new ResponseEntity<>(newVisa, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Visa> updateVisa(@RequestBody Visa visa ){
        Visa updateVisa = visaService.updateVisa(visa);
        return new ResponseEntity<>(updateVisa, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteVisa(@PathVariable("id") Visa id) {
        visaService.deleteVisa(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
