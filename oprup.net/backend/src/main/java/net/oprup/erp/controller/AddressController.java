package net.oprup.erp.controller;
import net.oprup.erp.model.Address;
import net.oprup.erp.model.Employee;
import net.oprup.erp.service.AddressService;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/address")
@CrossOrigin("*")

public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Address>> getAllAddress(){
        List<Address> address=addressService.findAllAddress();
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @GetMapping("/find/{employeeId}")
    public ResponseEntity<?> getAddressByEmployeeId(@PathVariable("employeeId") Long employeeId){
        Employee emp = new Employee();
        emp.setEmployeeId(employeeId);
        List<Address> employeeAddress = addressService.getAddressByEmployeeId(emp);
        return new ResponseEntity<>(employeeAddress, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        Address newAddress = addressService.addAddress(address);
        return new ResponseEntity<>(newAddress, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address ){
        Address updateAddress = addressService.updateAddress(address);
        return new ResponseEntity<>(updateAddress, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable("id") Address id) {
        addressService.deleteAddress(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
