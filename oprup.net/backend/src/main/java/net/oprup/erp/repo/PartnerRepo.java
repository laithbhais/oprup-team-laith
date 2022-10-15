package net.oprup.erp.repo;

import net.oprup.erp.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface PartnerRepo extends JpaRepository<Partner,Long> {


    Optional<Partner> findByPartnerId(Long partnerId);

    void deleteByPartnerId(Long id);

    @Query("select e from Partner e where e.deleteFlag =1")
    List<Partner> findAllPartners();


}
