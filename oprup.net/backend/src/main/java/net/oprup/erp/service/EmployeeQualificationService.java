package net.oprup.erp.service;

import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.Employee;
import net.oprup.erp.model.EmployeeQualification;
import net.oprup.erp.repo.EmployeeQualificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeQualificationService {

    private  EmployeeQualificationRepo employeeQualificationRepo;

    @Autowired
    public EmployeeQualificationService(EmployeeQualificationRepo employeeQualificationRepo) {
        this.employeeQualificationRepo = employeeQualificationRepo;
    }

    public EmployeeQualification addEmployeeQualification(EmployeeQualification employeeQualification){
        employeeQualification.setDeleteFlag(1);
        // return employeeQualificationRepo.save(employeeQualification);
        return employeeQualificationRepo.save(employeeQualification);
    }

    public List<EmployeeQualification> findAllEmployeeQualification(){
        return employeeQualificationRepo.findEmployeeQualificationByDeleteFlag();
    }

    public EmployeeQualification updateEmployeeQualification(EmployeeQualification employeeQualification){
        employeeQualification.setDeleteFlag(1);
        return employeeQualificationRepo.save(employeeQualification);
    }

    public EmployeeQualification findEmployeeQualificationByEmployeeQualificationId(Long employeeQualificationId){
        return employeeQualificationRepo.findByEmployeeQualificationId(employeeQualificationId)
                .orElseThrow(() -> new NotFoundException("EmployeeQualification by id: " + employeeQualificationId + " not found"));
    }

    public List<EmployeeQualification> getByEmployeeId(Employee employee){
        return employeeQualificationRepo.findByEmployeeId(employee);
    }

    public  EmployeeQualification deleteEmployeeQualification(EmployeeQualification employeeQualification){
        employeeQualification.setDeleteFlag(0);
        return employeeQualificationRepo.save(employeeQualification);
    }

}
