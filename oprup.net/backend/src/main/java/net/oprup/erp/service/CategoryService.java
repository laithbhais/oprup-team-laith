package net.oprup.erp.service;



import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import net.oprup.erp.repo.CategoryRepo;

@Service
@Transactional
public class CategoryService {
    private final CategoryRepo Repo;

    @Autowired
    public CategoryService(CategoryRepo repo) {
        Repo = repo;
    }


    public Category addCategory(Category category){
        category.setDeleteFlag(1);
        return Repo.save(category);
    }
    public List<Category> findAllCategory(){
        return  Repo.findAllCategory();
    }

    public Category findCategoryByCategoryId(Long categoryId){
        return Repo.findCategoryByCategoryId(categoryId)
                .orElseThrow(() -> new NotFoundException("category by id: " + categoryId + " not found"));
    }

    public Category deleteCategory(Category category){
        category.setDeleteFlag(0);
        return Repo.save(category);
    }
    public Category updateCategory(Category category){
        category.setDeleteFlag(1);
        return Repo.save(category);
    }



}
