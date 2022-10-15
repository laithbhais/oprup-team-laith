package net.oprup.erp.controller;
import net.oprup.erp.model.Section;
import net.oprup.erp.model.Department;
import net.oprup.erp.service.SectionService;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/section")
@CrossOrigin("*")

public class SectionController {

    private SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Section>> getAllSection(){
        List<Section> section=sectionService.findAllSections();
        return new ResponseEntity<>(section, HttpStatus.OK);
    }

    @GetMapping("/find/{departmentId}")
    public ResponseEntity<?> getSectionsByDepartmentId(@PathVariable("departmentId") Long departmentId){
        Department emp = new Department();
        emp.setDepartmentId(departmentId);
        List<Section> departmentSection = sectionService.getSectionsByDepartmentId(emp);
        return new ResponseEntity<>(departmentSection, HttpStatus.OK);
    }

    

    @PostMapping("/add")
    public ResponseEntity<Section> addSection(@RequestBody Section section){
        Section newSection = sectionService.addSection(section);
        return new ResponseEntity<>(newSection, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Section> updateSection(@RequestBody Section section ){
        Section updateSection = sectionService.updateSection(section);
        return new ResponseEntity<>(updateSection, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteSection(@PathVariable("id") Section id) {
        sectionService.deleteSection(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
