package net.oprup.erp.controller;

import net.oprup.erp.model.Employee;
import net.oprup.erp.model.EmployeeBank;
import net.oprup.erp.model.EmployeeMajor;
import net.oprup.erp.service.EmployeeMajorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeeMajor")
@CrossOrigin(origins = "*")
public class EmployeeMajorController {
    private final EmployeeMajorService employeeMajorService;

    public EmployeeMajorController(EmployeeMajorService employeeMajorService) {
        this.employeeMajorService = employeeMajorService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeMajor>> getAll(){
        List<EmployeeMajor> employeeMajor = employeeMajorService.findAllEmployeeMajor();
        return new ResponseEntity<>(employeeMajor, HttpStatus.OK);
    }
//    @GetMapping("/find/{employeeMajorId}")
//    public ResponseEntity<EmployeeMajor> getById(@PathVariable("employeeMajorId") Long employeeMajorId){
//        EmployeeMajor employeeMajor = employeeMajorService.findEmployeeMajorByEmployeeMajorId(employeeMajorId);
//        return new ResponseEntity<>(employeeMajor, HttpStatus.OK);
//    }
    @GetMapping("/find/{employeeId}")
    public ResponseEntity<?> findMajorsByEmployeeId(@PathVariable("employeeId") Long employeeId){
        Employee emp = new Employee();
        emp.setEmployeeId(employeeId);
        List<EmployeeMajor> employeeMajors = employeeMajorService.getMajorsByEmployeeId(emp);
        return new ResponseEntity<>(employeeMajors, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<EmployeeMajor> addEmployeeMajor(@RequestBody EmployeeMajor employeeMajor){
        EmployeeMajor newEmployeeMajor = employeeMajorService.addEmployeeMajor(employeeMajor);
        return new ResponseEntity<>(newEmployeeMajor, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<EmployeeMajor> updateEmployeeMajor(@RequestBody EmployeeMajor employeeMajor){
        EmployeeMajor updateEmployeeMajor = employeeMajorService.updateEmployeeMajor(employeeMajor);
        return new ResponseEntity<>(updateEmployeeMajor, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeeMajor(@PathVariable("id") EmployeeMajor id) {
        employeeMajorService.deleteEmployeeMajor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
