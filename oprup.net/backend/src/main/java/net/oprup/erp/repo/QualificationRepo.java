package net.oprup.erp.repo;

import net.oprup.erp.model.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QualificationRepo extends JpaRepository<Qualification, Long> {

    Optional<Qualification> findByQualificationId(Long id);

    void deleteByQualificationId(Long id);

    @Query("select e from Qualification  e where e.deleteFlag =1")
    List<Qualification> findAllQualifications();

   }