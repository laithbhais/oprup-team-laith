package net.oprup.erp.service;

import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.Qualification;
import net.oprup.erp.repo.QualificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class QualificationService {

    private QualificationRepo qualificationRepo;

    @Autowired
    public QualificationService(QualificationRepo qualificationRepo) {
        this.qualificationRepo = qualificationRepo;
    }

    public List<Qualification> findAllQualifications(){
        return  qualificationRepo.findAllQualifications();
    }

    public Qualification findQualificationById(Long id) {
        return qualificationRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("User by id " + id + " was not found"));
    }

    public Qualification addQualification(Qualification qualification) {
        qualification.setDeleteFlag(1);
        return qualificationRepo.save(qualification);
    }

    public Qualification updateQualification(Qualification qualification) {
        qualification.setDeleteFlag(1);
        return qualificationRepo.save(qualification);
    }

    public Qualification deleteQualification(Qualification qualification){
        qualification.setDeleteFlag(0);
        return qualificationRepo.save(qualification);
    }

}
