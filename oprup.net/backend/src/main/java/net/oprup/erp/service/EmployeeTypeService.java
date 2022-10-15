package net.oprup.erp.service;

import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.EmployeeType;
import net.oprup.erp.repo.EmployeeTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeTypeService {

    private  EmployeeTypeRepo employeeTypeRepo;

    @Autowired
    public EmployeeTypeService(EmployeeTypeRepo employeeTypeRepo) {
        this.employeeTypeRepo = employeeTypeRepo;
    }

    public EmployeeType addEmployeeType(EmployeeType employeeType){
        employeeType.setDeleteFlag(1);
        // return employeeTypeRepo.save(employeeType);
        return employeeTypeRepo.save(employeeType);
    }

    public List<EmployeeType> findAllEmployeeType(){
        return employeeTypeRepo.findAllEmployeeTypes();
    }

    public EmployeeType updateEmployeeType(EmployeeType employeeType){
        employeeType.setDeleteFlag(1);
        return employeeTypeRepo.save(employeeType);
    }

    public EmployeeType findEmployeeTypeByEmployeeTypeId(Long employeeTypeId){
        return employeeTypeRepo.findByEmployeeTypeId(employeeTypeId)
                .orElseThrow(() -> new NotFoundException("EmployeeType by id: " + employeeTypeId + " not found"));
    }

    public  EmployeeType deleteEmployeeType(EmployeeType employeeType){
        employeeType.setDeleteFlag(0);
        return employeeTypeRepo.save(employeeType);
    }

}
