package net.oprup.erp.service;

import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.TopManagement;
import net.oprup.erp.repo.TopManagementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TopManagementService {
    
    private  TopManagementRepo topmanagementRepo;

    @Autowired
    public TopManagementService(TopManagementRepo topmanagementRepo) {
        this.topmanagementRepo = topmanagementRepo;
    }

    public TopManagement addTopManagement(TopManagement topmanagement){
        topmanagement.setDeleteFlag(1);
        return topmanagementRepo.save(topmanagement);
    }

    public List<TopManagement> findAllTopManagements(){
        return  topmanagementRepo.findAllTopManagements();
    }

    public TopManagement updateTopManagements(TopManagement topmanagement){
        topmanagement.setDeleteFlag(1);
        return topmanagementRepo.save(topmanagement);
    }

    public TopManagement findTopManagementByTopManagementId(Long id){
        return topmanagementRepo.findByTopManagementId(id)
                .orElseThrow(() -> new NotFoundException("Department by id: " + id + " not found"));
    }

    public TopManagement deleteByTopManagementId(TopManagement topManagement){
        topManagement.setDeleteFlag(0);
        return topmanagementRepo.save(topManagement);
    }


}
