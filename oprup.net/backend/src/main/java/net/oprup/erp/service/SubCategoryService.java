package net.oprup.erp.service;


import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.Category;
import net.oprup.erp.model.SubCategory;
import net.oprup.erp.repo.SubCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SubCategoryService {

    private final SubCategoryRepo Repo;
    @Autowired
    public SubCategoryService(SubCategoryRepo repo) {
        Repo = repo;
    }
    public SubCategory addSubCategory(SubCategory subCategory){
        subCategory.setDeleteFlag(1);
        return Repo.save(subCategory);
    }
    public List<SubCategory> findAllSubCategory(){
        return  Repo.deleteSubCategoryByDeleteFlag();
    }

    public SubCategory findSubCategoryById(Long subCategoryId){
        return Repo.findSubCategoryBysubcategoryId(subCategoryId)
                .orElseThrow(() -> new NotFoundException("subCategory by id: " + subCategoryId + " not found"));
    }

    public SubCategory deleteSubCategory(SubCategory subCategory){
        subCategory.setDeleteFlag(0);
        return Repo.save(subCategory);
    }
    public SubCategory updateSubCategory(SubCategory subCategory){
        subCategory.setDeleteFlag(1);
        return Repo.save(subCategory);
    }

    public List<SubCategory> getSubCategoriesByCategory(Category category) {
        return Repo.findSubCategoryByCategory(category);

    }

}

