package net.oprup.erp.controller;



import net.oprup.erp.model.Category;
import net.oprup.erp.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAll(){
        List<Category> records = service.findAllCategory();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping("/find/{categoryId}")
    public ResponseEntity<Category> getById(@PathVariable("categoryId") Long categoryId){
        Category record = service.findCategoryByCategoryId(categoryId);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category record){
        Category newRecord = service.addCategory(record);
        return new ResponseEntity<>(newRecord, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Category> update(@RequestBody Category record){
        Category updateRecord = service.updateCategory(record);
        return new ResponseEntity<>(updateRecord, HttpStatus.OK);
    }

    @PutMapping("/delete")
    public ResponseEntity<Category> delete(@RequestBody Category record){
        Category deleteRecord = service.deleteCategory(record);
        return new ResponseEntity<>(deleteRecord, HttpStatus.OK);
    }


}

