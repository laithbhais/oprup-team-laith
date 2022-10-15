package net.oprup.erp.repo;

import net.oprup.erp.model.InsuranceCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InsuranceCompanyRepo extends JpaRepository<InsuranceCompany,Long> {

    Optional<InsuranceCompany> findByInsuranceCompanyId(Long insuranceCompanyId);

    void deleteByInsuranceCompanyId(Long id);

    @Query("select e from InsuranceCompany e where e.deleteFlag =1")
    List<InsuranceCompany> findAllInsuranceCompanys();

}