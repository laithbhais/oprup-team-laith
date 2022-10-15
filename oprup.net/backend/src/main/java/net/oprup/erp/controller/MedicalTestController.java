package net.oprup.erp.controller;
import net.oprup.erp.model.MedicalTest;
import net.oprup.erp.model.Employee;
import net.oprup.erp.service.MedicalTestService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/medicalTest")
@CrossOrigin("*")

public class MedicalTestController {

    private MedicalTestService medicalTestService;

    public MedicalTestController(MedicalTestService medicalTestService) {
        this.medicalTestService = medicalTestService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MedicalTest>> getAllMedicalTest(){
        List<MedicalTest> medicalTest=medicalTestService.findAllMedicalTest();
        return new ResponseEntity<>(medicalTest, HttpStatus.OK);
    }

    @GetMapping("/find/{employeeId}")
    public ResponseEntity<?> getMedicalTestByEmployeeId(@PathVariable("employeeId") Long employeeId){
        Employee emp = new Employee();
        emp.setEmployeeId(employeeId);
        List<MedicalTest> employeeMedicalTest = medicalTestService.getMedicalTestByEmployeeId(emp);
        return new ResponseEntity<>(employeeMedicalTest, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<MedicalTest> addMedicalTest(@RequestBody MedicalTest medicalTest){
        MedicalTest newMedicalTest = medicalTestService.addMedicalTest(medicalTest);
        return new ResponseEntity<>(newMedicalTest, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<MedicalTest> updateMedicalTest(@RequestBody MedicalTest medicalTest ){
        MedicalTest updateMedicalTest = medicalTestService.updateMedicalTest(medicalTest);
        return new ResponseEntity<>(updateMedicalTest, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteMedicalTest(@PathVariable("id") MedicalTest id) {
        medicalTestService.deleteMedicalTest(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
