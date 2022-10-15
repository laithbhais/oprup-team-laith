package net.oprup.erp.repo;

import net.oprup.erp.model.Employee;
import net.oprup.erp.model.MedicalTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MedicalTestRepo extends JpaRepository<MedicalTest, Long> {


    @Query(value = "select * from medical_test as e where e.delete_flag =1 and e.employee_id =:employee_id",nativeQuery = true)
    List<MedicalTest> findMedicalTestByEmployeeId(@Param("employee_id") Employee employee);




//    void deleteMedicalTestByMedicalTestId(Long id);

    @Query("select e from MedicalTest e where e.deleteFlag =1")
    List<MedicalTest> findMedicalTestByDeleteFlag();

}
