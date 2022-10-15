package net.oprup.erp.repo;

import net.oprup.erp.model.Employee;
import net.oprup.erp.model.EmployeeBank;
import net.oprup.erp.model.EmployeeUniversity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeUniversityRepo extends JpaRepository<EmployeeUniversity, Long> {


//    Optional<EmployeeUniversity> findByEmployeeUniversityId(Long employeeUniversityId);

    @Query(value = "select * from employee_university as e where e.delete_flag =1 and e.employee_id =:employee_id",nativeQuery = true)
    List<EmployeeUniversity> findUniversitiesByEmployeeId(@Param("employee_id") Employee employee);

//    void deleteEmployeeUniversityByEmployeeUniversityId(Long id);

    @Query("select e from EmployeeUniversity e where e.deleteFlag =1")
    List<EmployeeUniversity> findEmployeeUniversityByDeleteFlag();

}
