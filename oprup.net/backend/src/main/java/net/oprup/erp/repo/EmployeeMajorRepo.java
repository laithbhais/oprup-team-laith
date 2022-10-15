package net.oprup.erp.repo;

import net.oprup.erp.model.Employee;
import net.oprup.erp.model.EmployeeBank;
import net.oprup.erp.model.EmployeeMajor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeMajorRepo extends JpaRepository<EmployeeMajor, Long> {


//    Optional<EmployeeMajor> findByEmployeeMajorId(Long employeeMajorId);

    @Query(value = "select * from employee_major as e where e.delete_flag =1 and e.employee_id =:employee_id",nativeQuery = true)
    List<EmployeeMajor> findMajorsByEmployeeId(@Param("employee_id") Employee employee);

//    void deleteEmployeeMajorByEmployeeMajorId(Long id);

    @Query("select e from EmployeeMajor e where e.deleteFlag =1")
    List<EmployeeMajor> findEmployeeMajorByDeleteFlag();

}
