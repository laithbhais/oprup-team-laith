package net.oprup.erp.repo;


import net.oprup.erp.model.Category;
import net.oprup.erp.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepo extends JpaRepository<SubCategory, Long> {


    Optional<SubCategory> findSubCategoryBysubcategoryId(Long subcategoryId);

    @Query("select e from SubCategory e where e.deleteFlag =1")
    List<SubCategory> deleteSubCategoryByDeleteFlag();

    @Query("select e from SubCategory e where e.deleteFlag =1")
    List<SubCategory> findSubCategoryByCategory(Category category);


}


