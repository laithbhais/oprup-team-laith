package net.oprup.erp.repo;

import net.oprup.erp.model.TopManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopManagementRepo extends JpaRepository<TopManagement,Long> {

    Optional<TopManagement> findByTopManagementId(Long topManagementId);

    void deleteByTopManagementId(Long id);

    @Query("select e from  TopManagement e where e.deleteFlag =1")
    List<TopManagement> findAllTopManagements();
}
