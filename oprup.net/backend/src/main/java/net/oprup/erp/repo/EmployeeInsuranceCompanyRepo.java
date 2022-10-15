package net.oprup.erp.repo;

import net.oprup.erp.model.Employee;
import net.oprup.erp.model.EmployeeBank;
import net.oprup.erp.model.EmployeeInsuranceCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeInsuranceCompanyRepo extends JpaRepository<EmployeeInsuranceCompany, Long> {


    Optional<EmployeeInsuranceCompany> findByEmployeeInsuranceCompanyId(Long employeeInsuranceCompanyId);

    void deleteEmployeeInsuranceCompanyByEmployeeInsuranceCompanyId(Long id);




    @Query(value = "select * from employee_insurance_company as e where e.delete_flag =1 and e.employee_id =:employee_id",nativeQuery = true)
    List<EmployeeInsuranceCompany> findInsuranceCompaniesByEmployeeId(@Param("employee_id") Employee employee);

}
