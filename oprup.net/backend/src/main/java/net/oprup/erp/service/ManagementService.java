package net.oprup.erp.service;

import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.Management;
import net.oprup.erp.repo.ManagementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ManagementService {

    private  ManagementRepo managementRepo;

    @Autowired
    public ManagementService(ManagementRepo managementRepo) {
        this.managementRepo = managementRepo;
    }

    public Management addManagement(Management management){
        management.setDeleteFlag(1);
        // return managementRepo.save(management);
        return managementRepo.save(management);
    }

    public List<Management> findAllManagement(){
        return managementRepo.findAllManagements();
    }

    public Management updateManagement(Management management){
        management.setDeleteFlag(1);
        return managementRepo.save(management);
    }

    public Management findManagementByManagementId(Long managementId){
        return managementRepo.findByManagementId(managementId)
                .orElseThrow(() -> new NotFoundException("Management by id: " + managementId + " not found"));
    }

    public  Management deleteManagement(Management management){
        management.setDeleteFlag(0);
        return managementRepo.save(management);
    }

}
