package net.oprup.erp.repo;

import net.oprup.erp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    Optional<Employee> findByEmployeeId(Long employeeId);

    void deleteByEmployeeId(Long id);

    @Query("select e from Employee e where e.deleteFlag =1")
    List<Employee> findAllEmployees();

}