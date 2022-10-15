package net.oprup.erp.service;

import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.SalaryObject;
import net.oprup.erp.repo.SalaryObjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SalaryObjectService {
    private SalaryObjectRepo salaryObjectRepo;
    @Autowired
    public SalaryObjectService(SalaryObjectRepo salaryObjectRepo) {
        this.salaryObjectRepo = salaryObjectRepo;
    }
    public SalaryObject addSalaryObject(SalaryObject salary){
        salary.setDeleteFlag(1);
        // return majorRepo.save(major);
        return (SalaryObject) salaryObjectRepo.save(salary);
    }

    public List<SalaryObject> findAllSalaryObject(){
        return salaryObjectRepo.findAllSalaryObjects();
    }

    public SalaryObject updateSalaryObject(SalaryObject salary){
        salary.setDeleteFlag(1);
        return salaryObjectRepo.save(salary);
    }

    public SalaryObject findSalaryObjectBySalaryObjectId(Long salaryObjectId){
        return salaryObjectRepo.findById(salaryObjectId)
                .orElseThrow(() -> new NotFoundException("Major by id: " + salaryObjectId + " not found"));
    }

    public  SalaryObject deleteSalaryObject(SalaryObject salary){
        salary.setDeleteFlag(0);
        return salaryObjectRepo.save(salary);
    }
}
