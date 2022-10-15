package net.oprup.erp.repo;

import net.oprup.erp.model.Management;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManagementRepo extends JpaRepository<Management,Long> {

    Optional<Management> findByManagementId(Long managementId);

    void deleteByManagementId(Long id);

    @Query("select e from Management e where e.deleteFlag =1")
    List<Management> findAllManagements();

}