package net.oprup.erp.repo;

import net.oprup.erp.model.Employee;
import net.oprup.erp.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ExperienceRepo extends JpaRepository<Experience, Long> {


    @Query(value = "select * from experience as e where e.delete_flag =1 and e.employee_id =:employee_id",nativeQuery = true)
    List<Experience> findExperienceByEmployeeId(@Param("employee_id") Employee employee);




//    void deleteExperienceByExperienceId(Long id);

    @Query("select e from Experience e where e.deleteFlag =1")
    List<Experience> findExperienceByDeleteFlag();

}
