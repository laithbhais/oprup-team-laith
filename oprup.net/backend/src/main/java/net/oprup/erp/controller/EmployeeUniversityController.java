package net.oprup.erp.controller;

import net.oprup.erp.model.Employee;
import net.oprup.erp.model.EmployeeBank;
import net.oprup.erp.model.EmployeeUniversity;
import net.oprup.erp.service.EmployeeUniversityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeeUniversity")
@CrossOrigin(origins = "*")
public class EmployeeUniversityController {
    private final EmployeeUniversityService employeeUniversityService;

    public EmployeeUniversityController(EmployeeUniversityService employeeUniversityService) {
        this.employeeUniversityService = employeeUniversityService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeUniversity>> getAll(){
        List<EmployeeUniversity> employeeUniversity = employeeUniversityService.findAllEmployeeUniversity();
        return new ResponseEntity<>(employeeUniversity, HttpStatus.OK);
    }
//    @GetMapping("/find/{employeeUniversityId}")
//    public ResponseEntity<EmployeeUniversity> getById(@PathVariable("employeeUniversityId") Long employeeUniversityId){
//        EmployeeUniversity employeeUniversity = employeeUniversityService.findEmployeeUniversityByEmployeeUniversityId(employeeUniversityId);
//        return new ResponseEntity<>(employeeUniversity, HttpStatus.OK);
//    }

    @GetMapping("/find/{employeeId}")
    public ResponseEntity<?> findUniversitiesByEmployeeId(@PathVariable("employeeId") Long employeeId){
        Employee emp = new Employee();
        emp.setEmployeeId(employeeId);
        List<EmployeeUniversity> employeeUniversities = employeeUniversityService.getUniversitiesByEmployeeId(emp);
        return new ResponseEntity<>(employeeUniversities, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<EmployeeUniversity> addEmployeeUniversity(@RequestBody EmployeeUniversity employeeUniversity){
        EmployeeUniversity newEmployeeUniversity = employeeUniversityService.addEmployeeUniversity(employeeUniversity);
        return new ResponseEntity<>(newEmployeeUniversity, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<EmployeeUniversity> updateEmployeeUniversity(@RequestBody EmployeeUniversity employeeUniversity){
        EmployeeUniversity updateEmployeeUniversity = employeeUniversityService.updateEmployeeUniversity(employeeUniversity);
        return new ResponseEntity<>(updateEmployeeUniversity, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeeUniversity(@PathVariable("id") EmployeeUniversity id) {
        employeeUniversityService.deleteEmployeeUniversity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
