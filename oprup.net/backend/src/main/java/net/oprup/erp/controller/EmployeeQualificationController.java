package net.oprup.erp.controller;

import net.oprup.erp.model.Employee;
import net.oprup.erp.model.EmployeeQualification;
import net.oprup.erp.service.EmployeeQualificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeeQualification")
@CrossOrigin(origins = "*")
public class EmployeeQualificationController {
    private final EmployeeQualificationService employeeQualificationService;

    public EmployeeQualificationController(EmployeeQualificationService employeeQualificationService) {
        this.employeeQualificationService = employeeQualificationService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeQualification>> getAll(){
        List<EmployeeQualification> employeeQualification = employeeQualificationService.findAllEmployeeQualification();
        return new ResponseEntity<>(employeeQualification, HttpStatus.OK);
    }
//    @GetMapping("/find/{employeeQualificationId}")
//    public ResponseEntity<EmployeeQualification> getById(@PathVariable("employeeQualificationId") Long employeeQualificationId){
//        EmployeeQualification employeeQualification = employeeQualificationService.findEmployeeQualificationByEmployeeQualificationId(employeeQualificationId);
//        return new ResponseEntity<>(employeeQualification, HttpStatus.OK);
//    }

    @GetMapping("/find/{employee_id}")
    public ResponseEntity<?> getByEmpId(@PathVariable("employee_id") Long employeeId){
        Employee emp = new Employee();
        emp.setEmployeeId(employeeId);
        List<EmployeeQualification> employeeQualification = employeeQualificationService.getByEmployeeId(emp);
        return new ResponseEntity<>(employeeQualification, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeQualification> addEmployeeQualification(@RequestBody EmployeeQualification employeeQualification){
        EmployeeQualification newEmployeeQualification = employeeQualificationService.addEmployeeQualification(employeeQualification);
        return new ResponseEntity<>(newEmployeeQualification, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<EmployeeQualification> updateEmployeeQualification(@RequestBody EmployeeQualification employeeQualification){
        EmployeeQualification updateEmployeeQualification = employeeQualificationService.updateEmployeeQualification(employeeQualification);
        return new ResponseEntity<>(updateEmployeeQualification, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeeQualification(@PathVariable("id") EmployeeQualification id) {
        employeeQualificationService.deleteEmployeeQualification(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
