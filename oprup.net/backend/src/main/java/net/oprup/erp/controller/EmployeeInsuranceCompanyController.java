package net.oprup.erp.controller;

import net.oprup.erp.model.Employee;
import net.oprup.erp.model.EmployeeBank;
import net.oprup.erp.model.EmployeeInsuranceCompany;
import net.oprup.erp.service.EmployeeInsuranceCompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeeInsuranceCompany")
@CrossOrigin(origins = "*")
public class EmployeeInsuranceCompanyController {
    private final EmployeeInsuranceCompanyService employeeInsuranceCompanyService;

    public EmployeeInsuranceCompanyController(EmployeeInsuranceCompanyService employeeInsuranceCompanyService) {
        this.employeeInsuranceCompanyService = employeeInsuranceCompanyService;
    }

    @GetMapping("/find/{employeeId}")
    public ResponseEntity<?> getInsuranceCompaniesByEmployeeId(@PathVariable("employeeId") Long employeeId){
        Employee emp = new Employee();
        emp.setEmployeeId(employeeId);
        List<EmployeeInsuranceCompany> employeeInsuranceCompanies = employeeInsuranceCompanyService.getInsuranceCompaniesByEmployeeId(emp);
        return new ResponseEntity<>(employeeInsuranceCompanies, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeInsuranceCompany> addEmployeeInsuranceCompany(@RequestBody EmployeeInsuranceCompany employeeInsuranceCompany){
        EmployeeInsuranceCompany newEmployeeInsuranceCompany = employeeInsuranceCompanyService.addEmployeeInsuranceCompany(employeeInsuranceCompany);
        return new ResponseEntity<>(newEmployeeInsuranceCompany, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<EmployeeInsuranceCompany> updateEmployeeInsuranceCompany(@RequestBody EmployeeInsuranceCompany employeeInsuranceCompany){
        EmployeeInsuranceCompany updateEmployeeInsuranceCompany = employeeInsuranceCompanyService.updateEmployeeInsuranceCompany(employeeInsuranceCompany);
        return new ResponseEntity<>(updateEmployeeInsuranceCompany, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeeInsuranceCompany(@PathVariable("id") EmployeeInsuranceCompany id) {
        employeeInsuranceCompanyService.deleteEmployeeInsuranceCompany(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
