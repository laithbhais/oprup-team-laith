package net.oprup.erp.service;


import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.Category;
import net.oprup.erp.model.Department;
import net.oprup.erp.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DepartmentService {

    private final DepartmentRepo departmentRepo;

    @Autowired
    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public Department addDepartment(Department department){
        department.setDeleteFlag(1);
        return departmentRepo.save(department);
    }
    public List<Department> findAllDepartments(){
        return  departmentRepo.findAllDepartments();
    }

    public Department getDepartmentById(Long departmentId){
        return departmentRepo.findByDepartmentId(departmentId)
                .orElseThrow(() -> new NotFoundException("Department by id: " + departmentId + " not found"));
    }

    public Department updateDepartment(Department department){
        department.setDeleteFlag(1);
        return departmentRepo.save(department);
    }

    public Department deleteDepartment(Department department){
        department.setDeleteFlag(0);
        return departmentRepo.save(department);
    }

}
