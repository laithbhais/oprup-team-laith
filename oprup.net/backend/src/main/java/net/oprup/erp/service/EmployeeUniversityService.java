package net.oprup.erp.service;

import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.Employee;
import net.oprup.erp.model.EmployeeBank;
import net.oprup.erp.model.EmployeeUniversity;
import net.oprup.erp.repo.EmployeeUniversityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeUniversityService {

    private  EmployeeUniversityRepo employeeUniversityRepo;

    @Autowired
    public EmployeeUniversityService(EmployeeUniversityRepo employeeUniversityRepo) {
        this.employeeUniversityRepo = employeeUniversityRepo;
    }

    public EmployeeUniversity addEmployeeUniversity(EmployeeUniversity employeeUniversity){
        employeeUniversity.setDeleteFlag(1);
        // return employeeUniversityRepo.save(employeeUniversity);
        return employeeUniversityRepo.save(employeeUniversity);
    }

    public List<EmployeeUniversity> findAllEmployeeUniversity(){
        return employeeUniversityRepo.findEmployeeUniversityByDeleteFlag();
    }

    public EmployeeUniversity updateEmployeeUniversity(EmployeeUniversity employeeUniversity){
        employeeUniversity.setDeleteFlag(1);
        return employeeUniversityRepo.save(employeeUniversity);
    }


    public List<EmployeeUniversity> getUniversitiesByEmployeeId(Employee employee){
        return employeeUniversityRepo.findUniversitiesByEmployeeId(employee);
    }

//    public EmployeeUniversity findEmployeeUniversityByEmployeeUniversityId(Long employeeUniversityId){
//        return employeeUniversityRepo.findByEmployeeUniversityId(employeeUniversityId)
//                .orElseThrow(() -> new NotFoundException("EmployeeUniversity by id: " + employeeUniversityId + " not found"));
//    }

    public  EmployeeUniversity deleteEmployeeUniversity(EmployeeUniversity employeeUniversity){
        employeeUniversity.setDeleteFlag(0);
        return employeeUniversityRepo.save(employeeUniversity);
    }

}
