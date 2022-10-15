package net.oprup.erp.repo;

import net.oprup.erp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SectionRepo extends JpaRepository<Section, Long> {


    @Query(value = "select * from section as e where e.delete_flag =1 and e.department_id =:department_id",nativeQuery = true)
    List<Section> findSectionsByDepartmentId(@Param("department_id") Department department);

//    @Query("select s from Section s where s.deleteFlag =1")
//    List<Section> findAllSections();


    @Query("select e from Section e where e.deleteFlag =1")
    List<Section> findSectionByDeleteFlag();
}
