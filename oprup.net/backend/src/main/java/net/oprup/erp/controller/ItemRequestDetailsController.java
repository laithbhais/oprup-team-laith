package net.oprup.erp.controller;

import net.oprup.erp.model.ItemRequest;
import net.oprup.erp.model.ItemRequestDetails;
import net.oprup.erp.service.ItemRequestDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/itemRequestDetails")
@CrossOrigin(origins = "*")
public class ItemRequestDetailsController {
    private final ItemRequestDetailsService service;

    public ItemRequestDetailsController(ItemRequestDetailsService service) {
        this.service = service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<ItemRequestDetails>> getAll(){
        List<ItemRequestDetails> records = service.findAllItemRequestDetails();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping("/find/{itemRequestDetailsId}")
    public ResponseEntity<ItemRequestDetails> getById(@PathVariable("itemRequestDetailsId") Long itemRequestDetailsId){
        ItemRequestDetails record = service.findItemRequestDetailsById(itemRequestDetailsId);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<ItemRequestDetails> addItems(@RequestBody ItemRequestDetails record){
        ItemRequestDetails newRecord = service.addItemRequestDetails(record);
        return new ResponseEntity<>(newRecord, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<ItemRequestDetails> update(@RequestBody ItemRequestDetails record){
        ItemRequestDetails updateRecord = service.updateItemRequestDetails(record);
        return new ResponseEntity<>(updateRecord, HttpStatus.OK);
    }

    @PutMapping("/delete")
    public ResponseEntity<ItemRequestDetails> delete(@RequestBody ItemRequestDetails record){
        ItemRequestDetails deleteRecord = service.deleteItemRequestDetails(record);
        return new ResponseEntity<>(deleteRecord, HttpStatus.OK);
    }

    @GetMapping("/findCode/{itemRequestId}")
    public ResponseEntity<?> getItemRequestDetailsByItemRequest(@PathVariable("itemRequestId") Long itemRequestId){
        ItemRequest itemRequest =  new ItemRequest();
        itemRequest.setItemRequestId(itemRequestId);
        List<ItemRequestDetails> ItemRequestDetailsList = service.getItemRequestDetailsByItemRequest(itemRequest);
        return new ResponseEntity<>(ItemRequestDetailsList, HttpStatus.OK);
    }




}

