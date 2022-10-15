package net.oprup.erp.service;

import net.oprup.erp.model.Employee;
import net.oprup.erp.model.Residence;
import net.oprup.erp.repo.ResidenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ResidenceService {

    private  ResidenceRepo residenceRepo;

    @Autowired
    public ResidenceService(ResidenceRepo residenceRepo) {
        this.residenceRepo = residenceRepo;
    }

    public Residence addResidence(Residence residence){
        residence.setDeleteFlag(1);
        // return residenceRepo.save(residence);
        return residenceRepo.save(residence);
    }

    public List<Residence> findAllResidence(){
        return residenceRepo.findResidenceByDeleteFlag();
    }

    public Residence updateResidence(Residence residence){
        residence.setDeleteFlag(1);
        return residenceRepo.save(residence);
    }

    public List<Residence> getResidenceByEmployeeId(Employee employee){
        return residenceRepo.findResidenceByEmployeeId(employee);
    }


    public  Residence deleteResidence(Residence residence){
        residence.setDeleteFlag(0);
        return residenceRepo.save(residence);
    }

}
