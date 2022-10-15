package net.oprup.erp.controller;

import net.oprup.erp.model.Items;
import net.oprup.erp.service.ItemsService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "*")
public class ItemsController {
    private final ItemsService service;

    public ItemsController(ItemsService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Items>> getAll(){
        List<Items> records = service.findAllItems();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping("/find/{itemsId}")
    public ResponseEntity<Items> getById(@PathVariable("itemsId") Long itemsId){
        Items record = service.findItemsById(itemsId);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Items> addItems(@RequestBody Items record){
        Items newRecord = service.addItems(record);
        return new ResponseEntity<>(newRecord, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Items> update(@RequestBody Items record){
        Items updateRecord = service.updateItem(record);
        return new ResponseEntity<>(updateRecord, HttpStatus.OK);
    }

    @PutMapping("/delete")
    public ResponseEntity<Items> delete(@RequestBody Items record){
        Items deleteRecord = service.deleteItems(record);
        return new ResponseEntity<>(deleteRecord, HttpStatus.OK);
    }
    @GetMapping("/count")
    public  long count(){
        long records = service.countId();
        return (records);
    }

//
//    @PostMapping("/upload")
//    public ResponseEntity<List<String>> uploadFiles(@RequestParam("files")List<MultipartFile> multipartFiles) throws IOException {
//        List<String> filenames = new ArrayList<>();
//        for(MultipartFile file : multipartFiles) {
//            String filename = StringUtils.cleanPath(file.getOriginalFilename());
//            Path fileStorage = get(DIRECTORY, filename).toAbsolutePath().normalize();
//            copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
//            filenames.add(filename);
//        }
//        System.out.println("UPLOADED..!!!");
//        return ResponseEntity.ok().body(filenames);
//    }
//
//    // Define a method to download files
//    @GetMapping("download/{filename}")
//    public ResponseEntity<Resource> downloadFiles(@PathVariable("filename") String filename) throws IOException {
//        Path filePath = get(DIRECTORY).toAbsolutePath().normalize().resolve(filename);
//        if(!Files.exists(filePath)) {
//            throw new FileNotFoundException(filename + " was not found on the server");
//        }
//        Resource resource = (Resource) new UrlResource(filePath.toUri());
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("File-Name", filename);
//        httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + ((UrlResource) resource).getFilename());
//        return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
//                .headers(httpHeaders).body(resource);
//    }




}
