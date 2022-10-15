package net.oprup.erp.service;

import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.University;
import net.oprup.erp.repo.UniversityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UniversityService {

    private UniversityRepo universityRepo;

    @Autowired
    public UniversityService(UniversityRepo universityRepo) {
        this.universityRepo = universityRepo;
    }

    public List<University> findAllUniversities(){
        return  universityRepo.findAllUniversities();
    }

    public University findUniversityById(Long id) {
        return universityRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("User by id " + id + " was not found"));
    }

    public University addUniversity(University university) {
        university.setDeleteFlag(1);
        return universityRepo.save(university);
    }

    public University updateUniversity(University university) {
        university.setDeleteFlag(1);
        return universityRepo.save(university);
    }

    public University deleteByUniversityId(University university){
        university.setDeleteFlag(0);
        return universityRepo.save(university);
    }

}
