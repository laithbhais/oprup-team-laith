package net.oprup.erp.service;

import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.Employee;
import net.oprup.erp.model.EmployeeBank;
import net.oprup.erp.model.EmployeeInsuranceCompany;
import net.oprup.erp.repo.EmployeeInsuranceCompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeInsuranceCompanyService {

    private  EmployeeInsuranceCompanyRepo employeeInsuranceCompanyRepo;

    @Autowired
    public EmployeeInsuranceCompanyService(EmployeeInsuranceCompanyRepo employeeInsuranceCompanyRepo) {
        this.employeeInsuranceCompanyRepo = employeeInsuranceCompanyRepo;
    }

    public EmployeeInsuranceCompany addEmployeeInsuranceCompany(EmployeeInsuranceCompany employeeInsuranceCompany){
        employeeInsuranceCompany.setDeleteFlag(1);
        // return employeeInsuranceCompanyRepo.save(employeeInsuranceCompany);
        return employeeInsuranceCompanyRepo.save(employeeInsuranceCompany);
    }


    public List<EmployeeInsuranceCompany> getInsuranceCompaniesByEmployeeId(Employee employee){
        return employeeInsuranceCompanyRepo.findInsuranceCompaniesByEmployeeId(employee);
    }

    public EmployeeInsuranceCompany updateEmployeeInsuranceCompany(EmployeeInsuranceCompany employeeInsuranceCompany){
        employeeInsuranceCompany.setDeleteFlag(1);
        return employeeInsuranceCompanyRepo.save(employeeInsuranceCompany);
    }

    public EmployeeInsuranceCompany findEmployeeInsuranceCompanyByEmployeeInsuranceCompanyId(Long employeeInsuranceCompanyId){
        return employeeInsuranceCompanyRepo.findByEmployeeInsuranceCompanyId(employeeInsuranceCompanyId)
                .orElseThrow(() -> new NotFoundException("EmployeeInsuranceCompany by id: " + employeeInsuranceCompanyId + " not found"));
    }

    public  EmployeeInsuranceCompany deleteEmployeeInsuranceCompany(EmployeeInsuranceCompany employeeInsuranceCompany){
        employeeInsuranceCompany.setDeleteFlag(0);
        return employeeInsuranceCompanyRepo.save(employeeInsuranceCompany);
    }

}
