package net.oprup.erp.repo;

import net.oprup.erp.model.Employee;
import net.oprup.erp.model.JobInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface JobInfoRepo extends JpaRepository<JobInfo, Long>{



    @Query(value = "select * from Job_info as e where e.delete_flag =1 and e.employee_id =:employee_id",nativeQuery = true)
    List<JobInfo> findJobInfoByEmployeeId(@Param("employee_id") Employee employee);

    @Query("select e from JobInfo e where e.deleteFlag =1")
    List<JobInfo> findJobInfoByDeleteFlag();
}
