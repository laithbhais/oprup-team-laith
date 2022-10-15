package net.oprup.erp.repo;

import net.oprup.erp.model.Employee;
import net.oprup.erp.model.Residence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ResidenceRepo extends JpaRepository<Residence, Long> {


    @Query(value = "select * from residence as e where e.delete_flag =1 and e.employee_id =:employee_id",nativeQuery = true)
    List<Residence> findResidenceByEmployeeId(@Param("employee_id") Employee employee);




//    void deleteResidenceByResidenceId(Long id);

    @Query("select e from Residence e where e.deleteFlag =1")
    List<Residence> findResidenceByDeleteFlag();

}
