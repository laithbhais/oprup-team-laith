package net.oprup.erp.repo;

import net.oprup.erp.model.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobTitleRepo extends JpaRepository<JobTitle,Long> {

    Optional<JobTitle> findByJobTitleId(Long bankId);

    void deleteByJobTitleId(Long id);

    @Query("select e from JobTitle e where e.deleteFlag =1")
    List<JobTitle> findAllJobTitles();

}