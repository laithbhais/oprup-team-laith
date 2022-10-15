package net.oprup.erp.repo;


import net.oprup.erp.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UnitRepo extends JpaRepository<Unit, Long> {


    Optional<Unit> findUnitByunitId(Long unitId);

    @Query("select e from Unit e where e.deleteFlag =1")
    List<Unit> deleteUnitByDeleteFlag();


}
