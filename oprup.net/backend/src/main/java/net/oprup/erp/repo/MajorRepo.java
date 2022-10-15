package net.oprup.erp.repo;

import net.oprup.erp.model.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MajorRepo extends JpaRepository<Major,Long> {

    Optional<Major> findByMajorId(Long majorId);

    void deleteByMajorId(Long id);

    @Query("select e from Major e where e.deleteFlag =1")
    List<Major> findAllMajors();

}