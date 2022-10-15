package net.oprup.erp.controller;

import net.oprup.erp.model.ItemRequest;
import net.oprup.erp.service.ItemRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itemRequest")
@CrossOrigin(origins = "*")
public class ItemRequestController {
    private final ItemRequestService service;

    public ItemRequestController(ItemRequestService service) {
        this.service = service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<ItemRequest>> getAll(){
        List<ItemRequest> records = service.findAllItemRequest();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping("/find/{itemRequestId}")
    public ResponseEntity<ItemRequest> getById(@PathVariable("itemRequestId") Long itemRequestId){
        ItemRequest record = service.findItemRequestById(itemRequestId);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<ItemRequest> addItems(@RequestBody ItemRequest record){
        ItemRequest newRecord = service.addItemRequest(record);
        return new ResponseEntity<>(newRecord, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<ItemRequest> update(@RequestBody ItemRequest record){
        ItemRequest updateRecord = service.updateItemRequest(record);
        return new ResponseEntity<>(updateRecord, HttpStatus.OK);
    }

    @PutMapping("/delete")
    public ResponseEntity<ItemRequest> delete(@RequestBody ItemRequest record){
        ItemRequest deleteRecord = service.deleteItemRequest(record);
        return new ResponseEntity<>(deleteRecord, HttpStatus.OK);
    }
    @GetMapping("/count")
    public  long count(){
        long records = service.countId();
        return (records);
    }


}
