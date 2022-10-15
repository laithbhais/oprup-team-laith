package net.oprup.erp.repo;

import net.oprup.erp.model.Employee;
import net.oprup.erp.model.Visa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface VisaRepo extends JpaRepository<Visa, Long> {


    @Query(value = "select * from visa as e where e.delete_flag =1 and e.employee_id =:employee_id",nativeQuery = true)
    List<Visa> findVisaByEmployeeId(@Param("employee_id") Employee employee);




//    void deleteVisaByVisaId(Long id);

    @Query("select e from Visa e where e.deleteFlag =1")
    List<Visa> findVisaByDeleteFlag();

}
