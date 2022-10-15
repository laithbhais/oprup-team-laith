package net.oprup.erp.repo;



import net.oprup.erp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepo  extends JpaRepository<Category, Long> {


    Optional<Category> findCategoryByCategoryId(Long categoryId);

    @Query("select c from Category c where c.deleteFlag =1")
    List<Category> findAllCategory();


}
