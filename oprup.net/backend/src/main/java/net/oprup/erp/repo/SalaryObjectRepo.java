package net.oprup.erp.repo;
import net.oprup.erp.model.SalaryObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalaryObjectRepo extends JpaRepository<SalaryObject,Long> {

    Optional<SalaryObject> findBySalaryObjectId(Long salaryObjectId);

    void deleteBySalaryObjectId(SalaryObject salary);

    @Query("select e from SalaryObject e where e.deleteFlag =1")
    List<SalaryObject> findAllSalaryObjects();
}
