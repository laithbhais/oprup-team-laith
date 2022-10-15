package net.oprup.erp.service;

import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.InsuranceCompany;
import net.oprup.erp.repo.InsuranceCompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InsuranceCompanyService {

    private  InsuranceCompanyRepo insuranceCompanyRepo;

    @Autowired
    public InsuranceCompanyService(InsuranceCompanyRepo insuranceCompanyRepo) {
        this.insuranceCompanyRepo = insuranceCompanyRepo;
    }

    public InsuranceCompany addInsuranceCompany(InsuranceCompany insuranceCompany){
        insuranceCompany.setDeleteFlag(1);
        // return insuranceCompanyRepo.save(insuranceCompany);
        return insuranceCompanyRepo.save(insuranceCompany);
    }

    public List<InsuranceCompany> findAllInsuranceCompany(){
        return insuranceCompanyRepo.findAllInsuranceCompanys();
    }

    public InsuranceCompany updateInsuranceCompany(InsuranceCompany insuranceCompany){
        insuranceCompany.setDeleteFlag(1);
        return insuranceCompanyRepo.save(insuranceCompany);
    }

    public InsuranceCompany findInsuranceCompanyByInsuranceCompanyId(Long insuranceCompanyId){
        return insuranceCompanyRepo.findByInsuranceCompanyId(insuranceCompanyId)
                .orElseThrow(() -> new NotFoundException("InsuranceCompany by id: " + insuranceCompanyId + " not found"));
    }

    public  InsuranceCompany deleteInsuranceCompany(InsuranceCompany insuranceCompany){
        insuranceCompany.setDeleteFlag(0);
        return insuranceCompanyRepo.save(insuranceCompany);
    }

}
