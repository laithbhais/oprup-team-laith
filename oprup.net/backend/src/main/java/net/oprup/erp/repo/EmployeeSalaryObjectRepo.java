package net.oprup.erp.repo;

import net.oprup.erp.model.EmployeeSalaryObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeSalaryObjectRepo extends JpaRepository<EmployeeSalaryObject, Long> {


    Optional<EmployeeSalaryObject> findByEmployeeSalaryObjectId(Long employeeSalaryObjectId);

    void deleteEmployeeSalaryObjectByEmployeeSalaryObjectId(Long id);

    @Query("select e from EmployeeSalaryObject e where e.deleteFlag =1")
    List<EmployeeSalaryObject> findEmployeeSalaryObjectByDeleteFlag();

}
