package net.oprup.erp.repo;

import net.oprup.erp.model.Bank;
import net.oprup.erp.model.Category;
import net.oprup.erp.model.Department;
import net.oprup.erp.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

    @Query("select d from Department d where d.deleteFlag =1")
    List<Department> findAllDepartments();


    Optional<Department> findByDepartmentId(Long departmentId);
}
