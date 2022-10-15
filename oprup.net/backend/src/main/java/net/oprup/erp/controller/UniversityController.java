package net.oprup.erp.controller;
import net.oprup.erp.model.University;
import net.oprup.erp.service.UniversityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/university")
@CrossOrigin("*")
public class UniversityController {

    private UniversityService universityService;

    public  UniversityController(UniversityService universityService){
        this.universityService = universityService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<University>> getAllUniversities () {
        List<University> universities = universityService.findAllUniversities();
        return new ResponseEntity<>(universities, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<University> getUniversityById (@PathVariable("id") Long id) {
        University university = universityService.findUniversityById(id);
        return new ResponseEntity<>(university, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<University> addUniversity(@RequestBody University university) {
        University newUniversity = universityService.addUniversity(university);
        return new ResponseEntity<>(newUniversity, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<University> updateUniversity(@RequestBody University university) {
        University updateUniversity = universityService.updateUniversity(university);
        return new ResponseEntity<>(updateUniversity, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteUniversity(@PathVariable("id") University id) {
        universityService.deleteByUniversityId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
