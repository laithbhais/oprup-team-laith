package net.oprup.erp.controller;




import net.oprup.erp.model.Unit;
import net.oprup.erp.service.UnitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unit")
@CrossOrigin(origins = "*")
public class UnitController {

    private final UnitService service;


    public UnitController(UnitService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Unit>> getAll(){
        List<Unit> records = service.findAllUnit();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping("/find/{unitId}")
    public ResponseEntity<Unit> getById(@PathVariable("unitId") Long unitId){
        Unit record = service.findUnitById(unitId);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Unit> addUnit(@RequestBody Unit record){
        Unit newRecord = service.addUnit(record);
        return new ResponseEntity<>(newRecord, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Unit> update(@RequestBody Unit record){
        Unit updateRecord = service.updateUnit(record);
        return new ResponseEntity<>(updateRecord, HttpStatus.OK);
    }

    @PutMapping("/delete")
    public ResponseEntity<Unit> delete(@RequestBody Unit record){
        Unit deleteRecord = service.deleteUnit(record);
        return new ResponseEntity<>(deleteRecord, HttpStatus.OK);
    }


}



