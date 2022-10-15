package net.oprup.erp.controller;
import net.oprup.erp.model.EmployeeType;
import net.oprup.erp.service.EmployeeTypeService;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/employeeType")
@CrossOrigin("*")

public class EmployeeTypeController {

    private EmployeeTypeService employeeTypeService;

    public EmployeeTypeController(EmployeeTypeService employeeTypeService) {
        this.employeeTypeService = employeeTypeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeType>> getAllEmployeeType(){
        List<EmployeeType> employeeType=employeeTypeService.findAllEmployeeType();
        return new ResponseEntity<>(employeeType, HttpStatus.OK);
    }

    @GetMapping("/find/{employeeTypeId}")
    public ResponseEntity<EmployeeType> getEmployeeTypeById(@PathVariable("employeeTypeId") Long employeeTypeId){
        EmployeeType employeeType = employeeTypeService.findEmployeeTypeByEmployeeTypeId(employeeTypeId);
        return new ResponseEntity<>(employeeType, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeType> addEmployeeType(@RequestBody EmployeeType employeeType){
        EmployeeType newEmployeeType = employeeTypeService.addEmployeeType(employeeType);
        return new ResponseEntity<>(newEmployeeType, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeType> updateEmployeeType(@RequestBody EmployeeType employeeType ){
        EmployeeType updateEmployeeType = employeeTypeService.updateEmployeeType(employeeType);
        return new ResponseEntity<>(updateEmployeeType, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeeType(@PathVariable("id") EmployeeType id) {
        employeeTypeService.deleteEmployeeType(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
