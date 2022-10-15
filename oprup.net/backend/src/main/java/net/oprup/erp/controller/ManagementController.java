package net.oprup.erp.controller;
import net.oprup.erp.model.Management;
import net.oprup.erp.service.ManagementService;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/management")
@CrossOrigin("*")

public class ManagementController {

    private ManagementService managementService;

    public ManagementController(ManagementService managementService) {
        this.managementService = managementService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Management>> getAllManagement(){
        List<Management> management=managementService.findAllManagement();
        return new ResponseEntity<>(management, HttpStatus.OK);
    }

    @GetMapping("/find/{managementId}")
    public ResponseEntity<Management> getManagementById(@PathVariable("managementId") Long managementId){
        Management management = managementService.findManagementByManagementId(managementId);
        return new ResponseEntity<>(management, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Management> addManagement(@RequestBody Management management){
        Management newManagement = managementService.addManagement(management);
        return new ResponseEntity<>(newManagement, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Management> updateManagement(@RequestBody Management management ){
        Management updateManagement = managementService.updateManagement(management);
        return new ResponseEntity<>(updateManagement, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteManagement(@PathVariable("id") Management id) {
        managementService.deleteManagement(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
