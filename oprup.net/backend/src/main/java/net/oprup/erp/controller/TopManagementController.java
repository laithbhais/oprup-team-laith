package net.oprup.erp.controller;
import net.oprup.erp.model.TopManagement;
import net.oprup.erp.service.TopManagementService;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/topManagement")
@CrossOrigin("*")

public class TopManagementController {

    private TopManagementService topManagementService;

    public TopManagementController(TopManagementService topManagementService) {
        this.topManagementService = topManagementService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TopManagement>> getAllTopManagement(){
        List<TopManagement> major=topManagementService.findAllTopManagements();
        return new ResponseEntity<>(major, HttpStatus.OK);
    }

    @GetMapping("/find/{topManagementId}")
    public ResponseEntity<TopManagement> getTopManagementById(@PathVariable("topManagementId") Long topManagementId){
        TopManagement topManagement = topManagementService.findTopManagementByTopManagementId(topManagementId);
        return new ResponseEntity<>(topManagement, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TopManagement> addTopManagement(@RequestBody TopManagement topManagement){
        TopManagement newTopManagement = topManagementService.addTopManagement(topManagement);
        return new ResponseEntity<>(newTopManagement, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<TopManagement> updateTopManagement(@RequestBody TopManagement topManagement){
        TopManagement updateTopManagement = topManagementService.updateTopManagements(topManagement);
        return new ResponseEntity<>(updateTopManagement, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteTopManagement(@PathVariable("id") TopManagement id) {
        topManagementService.deleteByTopManagementId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
