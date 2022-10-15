package net.oprup.erp.service;



import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.Unit;
import net.oprup.erp.repo.UnitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UnitService {

    private final UnitRepo Repo;

    @Autowired
    public UnitService(UnitRepo repo) {
        Repo = repo;
    }
    public Unit addUnit(Unit unit){
        unit.setDeleteFlag(1);
        return Repo.save(unit);
    }
    public List<Unit> findAllUnit(){
        return  Repo.deleteUnitByDeleteFlag();
    }

    public Unit findUnitById(Long unitId){
        return Repo.findUnitByunitId(unitId)
                .orElseThrow(() -> new NotFoundException("Unit by id: " + unitId + " not found"));
    }

    public Unit deleteUnit(Unit unit){
        unit.setDeleteFlag(0);
        return Repo.save(unit);
    }
    public Unit updateUnit(Unit unit){
        unit.setDeleteFlag(1);
        return Repo.save(unit);
    }



}


