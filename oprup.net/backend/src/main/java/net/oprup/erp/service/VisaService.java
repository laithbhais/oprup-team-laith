package net.oprup.erp.service;

import net.oprup.erp.model.Employee;
import net.oprup.erp.model.Visa;
import net.oprup.erp.repo.VisaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VisaService {

    private  VisaRepo visaRepo;

    @Autowired
    public VisaService(VisaRepo visaRepo) {
        this.visaRepo = visaRepo;
    }

    public Visa addVisa(Visa visa){
        visa.setDeleteFlag(1);
        // return visaRepo.save(visa);
        return visaRepo.save(visa);
    }

    public List<Visa> findAllVisa(){
        return visaRepo.findVisaByDeleteFlag();
    }

    public Visa updateVisa(Visa visa){
        visa.setDeleteFlag(1);
        return visaRepo.save(visa);
    }

    public List<Visa> getVisaByEmployeeId(Employee employee){
        return visaRepo.findVisaByEmployeeId(employee);
    }


    public  Visa deleteVisa(Visa visa){
        visa.setDeleteFlag(0);
        return visaRepo.save(visa);
    }

}
