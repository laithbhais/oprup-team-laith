package net.oprup.erp.repo;

import net.oprup.erp.model.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeTypeRepo extends JpaRepository<EmployeeType,Long> {

    Optional<EmployeeType> findByEmployeeTypeId(Long employeeTypeId);

    void deleteByEmployeeTypeId(Long id);

    @Query("select e from EmployeeType e where e.deleteFlag =1")
    List<EmployeeType> findAllEmployeeTypes();

}