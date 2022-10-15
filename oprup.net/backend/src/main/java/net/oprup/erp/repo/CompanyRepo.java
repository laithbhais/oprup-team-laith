package net.oprup.erp.repo;

import net.oprup.erp.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepo extends JpaRepository<Company,Long> {

    Optional<Company> findByCompanyId(Long companyId);

    void deleteByCompanyId(Long id);

    @Query("select e from Company e where e.deleteFlag =1")
    List<Company> findAllCompanys();

}