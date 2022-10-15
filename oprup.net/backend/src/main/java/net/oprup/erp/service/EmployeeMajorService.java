package net.oprup.erp.service;

import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.Employee;
import net.oprup.erp.model.EmployeeBank;
import net.oprup.erp.model.EmployeeMajor;
import net.oprup.erp.repo.EmployeeMajorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeMajorService {

    private  EmployeeMajorRepo employeeMajorRepo;

    @Autowired
    public EmployeeMajorService(EmployeeMajorRepo employeeMajorRepo) {
        this.employeeMajorRepo = employeeMajorRepo;
    }

    public EmployeeMajor addEmployeeMajor(EmployeeMajor employeeMajor){
        employeeMajor.setDeleteFlag(1);
        // return employeeMajorRepo.save(employeeMajor);
        return employeeMajorRepo.save(employeeMajor);
    }

    public List<EmployeeMajor> findAllEmployeeMajor(){
        return employeeMajorRepo.findEmployeeMajorByDeleteFlag();
    }

    public EmployeeMajor updateEmployeeMajor(EmployeeMajor employeeMajor){
        employeeMajor.setDeleteFlag(1);
        return employeeMajorRepo.save(employeeMajor);
    }

    public List<EmployeeMajor> getMajorsByEmployeeId(Employee employee){
        return employeeMajorRepo.findMajorsByEmployeeId(employee);
    }

//    public EmployeeMajor findEmployeeMajorByEmployeeMajorId(Long employeeMajorId){
//        return employeeMajorRepo.findMajorsByEmployeeId(employeeMajorId)
//                .orElseThrow(() -> new NotFoundException("EmployeeMajor by id: " + employeeMajorId + " not found"));
//    }

    public  EmployeeMajor deleteEmployeeMajor(EmployeeMajor employeeMajor){
        employeeMajor.setDeleteFlag(0);
        return employeeMajorRepo.save(employeeMajor);
    }

}
