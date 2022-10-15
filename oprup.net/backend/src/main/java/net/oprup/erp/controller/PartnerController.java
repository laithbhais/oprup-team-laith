package net.oprup.erp.controller;
import net.oprup.erp.model.Partner;
import net.oprup.erp.service.PartnerService;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/partner")
@CrossOrigin("*")

public class PartnerController {

    private PartnerService partnerService;

    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Partner>> getAllPartner(){
        List<Partner> partner=partnerService.findAllPartner();
        return new ResponseEntity<>(partner, HttpStatus.OK);
    }

    @GetMapping("/find/{partnerId}")
    public ResponseEntity<Partner> getPartnerById(@PathVariable("partnerId") Long partnerId){
        Partner partner = partnerService.findPartnerByPartnerId(partnerId);
        return new ResponseEntity<>(partner, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Partner> addPartner(@RequestBody Partner partner){
        Partner newPartner = partnerService.addPartner(partner);
        return new ResponseEntity<>(newPartner, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Partner> updatePartner(@RequestBody Partner partner ){
        Partner updatePartner = partnerService.updatePartner(partner);
        return new ResponseEntity<>(updatePartner, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deletePartner(@PathVariable("id") Partner id) {
        partnerService.deletePartner(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
