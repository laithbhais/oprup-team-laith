package net.oprup.erp.repo;

import net.oprup.erp.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UniversityRepo extends JpaRepository<University, Long> {

    Optional<University> findByUniversityId(Long id);

    void deleteByUniversityId(Long id);

    @Query("select e from University  e where e.deleteFlag =1")
    List<University> findAllUniversities();

}
