package net.oprup.erp.service;

import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.Partner;
import net.oprup.erp.repo.PartnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PartnerService {

    private  PartnerRepo partnerRepo;

    @Autowired
    public PartnerService(PartnerRepo partnerRepo) {
        this.partnerRepo = partnerRepo;
    }

    public Partner addPartner(Partner partner){
        partner.setDeleteFlag(1);
        // return partnerRepo.save(partner);
        return partnerRepo.save(partner);
    }

    public List<Partner> findAllPartner(){
        return partnerRepo.findAllPartners();
    }

    public Partner updatePartner(Partner partner){
        partner.setDeleteFlag(1);
        return partnerRepo.save(partner);
    }

    public Partner findPartnerByPartnerId(Long partnerId){
        return partnerRepo.findByPartnerId(partnerId)
                .orElseThrow(() -> new NotFoundException("Partner by id: " + partnerId + " not found"));
    }

    public  Partner deletePartner(Partner partner){
        partner.setDeleteFlag(0);
        return partnerRepo.save(partner);
    }

}
