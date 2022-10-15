package net.oprup.erp.controller;



import net.oprup.erp.model.Category;
import net.oprup.erp.model.SubCategory;
import net.oprup.erp.service.SubCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subCategory")
@CrossOrigin(origins = "*")
public class SubCategoryController {
    private final SubCategoryService service;

    public SubCategoryController(SubCategoryService service) {
        this.service = service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<SubCategory>> getAll(){
        List<SubCategory> records = service.findAllSubCategory();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping("/find/{subCategoryId}")
    public ResponseEntity<SubCategory> getById(@PathVariable("subCategoryId") Long subCategoryId){
        SubCategory record = service.findSubCategoryById(subCategoryId);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<SubCategory> addSubCategory(@RequestBody SubCategory record){
        SubCategory newRecord = service.addSubCategory(record);
        return new ResponseEntity<>(newRecord, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<SubCategory> update(@RequestBody SubCategory record){
        SubCategory updateRecord = service.updateSubCategory(record);
        return new ResponseEntity<>(updateRecord, HttpStatus.OK);
    }

    @PutMapping("/delete")
    public ResponseEntity<SubCategory> delete(@RequestBody SubCategory record){
        SubCategory deleteRecord = service.deleteSubCategory(record);
        return new ResponseEntity<>(deleteRecord, HttpStatus.OK);
    }

    @GetMapping("/subCategoryByCategory/{categoryId}")
    public ResponseEntity<?> getSubCategoryByCategory(@PathVariable("categoryId") Long categoryId){
        Category category =  new Category();
        category.setCategoryId(categoryId);
        List<SubCategory> subCategoryByCategory = service.getSubCategoriesByCategory(category);
        return new ResponseEntity<>(subCategoryByCategory, HttpStatus.OK);
    }

}


