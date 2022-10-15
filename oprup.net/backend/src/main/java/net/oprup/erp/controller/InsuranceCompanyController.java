package net.oprup.erp.controller;
import net.oprup.erp.model.InsuranceCompany;
import net.oprup.erp.service.InsuranceCompanyService;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/insuranceCompany")
@CrossOrigin("*")

public class InsuranceCompanyController {

    private InsuranceCompanyService insuranceCompanyService;

    public InsuranceCompanyController(InsuranceCompanyService insuranceCompanyService) {
        this.insuranceCompanyService = insuranceCompanyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<InsuranceCompany>> getAllInsuranceCompany(){
        List<InsuranceCompany> insuranceCompany=insuranceCompanyService.findAllInsuranceCompany();
        return new ResponseEntity<>(insuranceCompany, HttpStatus.OK);
    }

    @GetMapping("/find/{insuranceCompanyId}")
    public ResponseEntity<InsuranceCompany> getInsuranceCompanyById(@PathVariable("insuranceCompanyId") Long insuranceCompanyId){
        InsuranceCompany insuranceCompany = insuranceCompanyService.findInsuranceCompanyByInsuranceCompanyId(insuranceCompanyId);
        return new ResponseEntity<>(insuranceCompany, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<InsuranceCompany> addInsuranceCompany(@RequestBody InsuranceCompany insuranceCompany){
        InsuranceCompany newInsuranceCompany = insuranceCompanyService.addInsuranceCompany(insuranceCompany);
        return new ResponseEntity<>(newInsuranceCompany, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<InsuranceCompany> updateInsuranceCompany(@RequestBody InsuranceCompany insuranceCompany ){
        InsuranceCompany updateInsuranceCompany = insuranceCompanyService.updateInsuranceCompany(insuranceCompany);
        return new ResponseEntity<>(updateInsuranceCompany, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteInsuranceCompany(@PathVariable("id") InsuranceCompany id) {
        insuranceCompanyService.deleteInsuranceCompany(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
