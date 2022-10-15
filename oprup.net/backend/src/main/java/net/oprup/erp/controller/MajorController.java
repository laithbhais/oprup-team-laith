package net.oprup.erp.controller;
import net.oprup.erp.model.Major;
import net.oprup.erp.service.MajorService;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/major")
@CrossOrigin("*") 

public class MajorController {
    
    private MajorService majorService;

    public MajorController(MajorService majorService) {
        this.majorService = majorService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Major>> getAllMajor(){
        List<Major> major=majorService.findAllMajor();
        return new ResponseEntity<>(major, HttpStatus.OK);
    }

    @GetMapping("/find/{majorId}")
    public ResponseEntity<Major> getMajorById(@PathVariable("majorId") Long majorId){
        Major major = majorService.findMajorByMajorId(majorId);
        return new ResponseEntity<>(major, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Major> addMajor(@RequestBody Major major){
        Major newMajor = majorService.addMajor(major);
        return new ResponseEntity<>(newMajor, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Major> updateMajor(@RequestBody Major major ){
        Major updateMajor = majorService.updateMajor(major);
        return new ResponseEntity<>(updateMajor, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteMajor(@PathVariable("id") Major id) {
        majorService.deleteMajor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
