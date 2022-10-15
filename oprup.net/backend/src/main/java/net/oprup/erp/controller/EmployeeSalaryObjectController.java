package net.oprup.erp.controller;

import net.oprup.erp.model.EmployeeSalaryObject;
import net.oprup.erp.service.EmployeeSalaryObjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeeSalaryObject")
@CrossOrigin(origins = "*")
public class EmployeeSalaryObjectController {
    private final EmployeeSalaryObjectService employeeSalaryObjectService;

    public EmployeeSalaryObjectController(EmployeeSalaryObjectService employeeSalaryObjectService) {
        this.employeeSalaryObjectService = employeeSalaryObjectService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeSalaryObject>> getAll(){
        List<EmployeeSalaryObject> employeeSalaryObject = employeeSalaryObjectService.findAllEmployeeSalaryObject();
        return new ResponseEntity<>(employeeSalaryObject, HttpStatus.OK);
    }
    @GetMapping("/find/{employeeSalaryObjectId}")
    public ResponseEntity<EmployeeSalaryObject> getById(@PathVariable("employeeSalaryObjectId") Long employeeSalaryObjectId){
        EmployeeSalaryObject employeeSalaryObject = employeeSalaryObjectService.findEmployeeSalaryObjectByEmployeeSalaryObjectId(employeeSalaryObjectId);
        return new ResponseEntity<>(employeeSalaryObject, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeSalaryObject> addEmployeeSalaryObject(@RequestBody EmployeeSalaryObject employeeSalaryObject){
        EmployeeSalaryObject newEmployeeSalaryObject = employeeSalaryObjectService.addEmployeeSalaryObject(employeeSalaryObject);
        return new ResponseEntity<>(newEmployeeSalaryObject, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<EmployeeSalaryObject> updateEmployeeSalaryObject(@RequestBody EmployeeSalaryObject employeeSalaryObject){
        EmployeeSalaryObject updateEmployeeSalaryObject = employeeSalaryObjectService.updateEmployeeSalaryObject(employeeSalaryObject);
        return new ResponseEntity<>(updateEmployeeSalaryObject, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeeSalaryObject(@PathVariable("id") EmployeeSalaryObject id) {
        employeeSalaryObjectService.deleteEmployeeSalaryObject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
