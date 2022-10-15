package net.oprup.erp.controller;
import net.oprup.erp.model.Qualification;
import net.oprup.erp.service.QualificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/qualification")
@CrossOrigin("*")
public class QualificationController {

    private QualificationService qualificationService;

    public  QualificationController(QualificationService qualificationService){
        this.qualificationService = qualificationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Qualification>> getAllQualifications () {
        List<Qualification> qualifications = qualificationService.findAllQualifications();
        return new ResponseEntity<>(qualifications, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Qualification> getQualificationById (@PathVariable("id") Long id) {
        Qualification qualification = qualificationService.findQualificationById(id);
        return new ResponseEntity<>(qualification, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Qualification> addQualification(@RequestBody Qualification qualification) {
        Qualification newQualification = qualificationService.addQualification(qualification);
        return new ResponseEntity<>(newQualification, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Qualification> updateQualification(@RequestBody Qualification qualification) {
        Qualification updateQualification = qualificationService.updateQualification(qualification);
        return new ResponseEntity<>(updateQualification, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteQualification(@PathVariable("id") Qualification id) {
        qualificationService.deleteQualification(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
