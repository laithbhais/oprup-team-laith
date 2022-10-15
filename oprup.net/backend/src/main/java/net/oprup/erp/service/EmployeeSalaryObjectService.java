package net.oprup.erp.service;

import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.EmployeeSalaryObject;
import net.oprup.erp.repo.EmployeeSalaryObjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeSalaryObjectService {

    private  EmployeeSalaryObjectRepo employeeSalaryObjectRepo;

    @Autowired
    public EmployeeSalaryObjectService(EmployeeSalaryObjectRepo employeeSalaryObjectRepo) {
        this.employeeSalaryObjectRepo = employeeSalaryObjectRepo;
    }

    public EmployeeSalaryObject addEmployeeSalaryObject(EmployeeSalaryObject employeeSalaryObject){
        employeeSalaryObject.setDeleteFlag(1);
        // return employeeSalaryObjectRepo.save(employeeSalaryObject);
        return employeeSalaryObjectRepo.save(employeeSalaryObject);
    }

    public List<EmployeeSalaryObject> findAllEmployeeSalaryObject(){
        return employeeSalaryObjectRepo.findEmployeeSalaryObjectByDeleteFlag();
    }

    public EmployeeSalaryObject updateEmployeeSalaryObject(EmployeeSalaryObject employeeSalaryObject){
        employeeSalaryObject.setDeleteFlag(1);
        return employeeSalaryObjectRepo.save(employeeSalaryObject);
    }

    public EmployeeSalaryObject findEmployeeSalaryObjectByEmployeeSalaryObjectId(Long employeeSalaryObjectId){
        return employeeSalaryObjectRepo.findByEmployeeSalaryObjectId(employeeSalaryObjectId)
                .orElseThrow(() -> new NotFoundException("EmployeeSalaryObject by id: " + employeeSalaryObjectId + " not found"));
    }

    public  EmployeeSalaryObject deleteEmployeeSalaryObject(EmployeeSalaryObject employeeSalaryObject){
        employeeSalaryObject.setDeleteFlag(0);
        return employeeSalaryObjectRepo.save(employeeSalaryObject);
    }

}
