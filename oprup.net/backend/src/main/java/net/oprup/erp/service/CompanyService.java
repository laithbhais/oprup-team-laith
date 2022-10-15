package net.oprup.erp.service;

import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.Company;
import net.oprup.erp.repo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompanyService {

    private  CompanyRepo companyRepo;

    @Autowired
    public CompanyService(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    public Company addCompany(Company company){
        company.setDeleteFlag(1);
        // return companyRepo.save(company);
        return companyRepo.save(company);
    }

    public List<Company> findAllCompany(){
        return companyRepo.findAllCompanys();
    }

    public Company updateCompany(Company company){
        company.setDeleteFlag(1);
        return companyRepo.save(company);
    }

    public Company findCompanyByCompanyId(Long companyId){
        return companyRepo.findByCompanyId(companyId)
                .orElseThrow(() -> new NotFoundException("Company by id: " + companyId + " not found"));
    }

    public  Company deleteCompany(Company company){
        company.setDeleteFlag(0);
        return companyRepo.save(company);
    }

}
