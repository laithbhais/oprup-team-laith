package net.oprup.erp.service;

import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.Major;
import net.oprup.erp.repo.MajorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MajorService {

    private  MajorRepo majorRepo;

    @Autowired
    public MajorService(MajorRepo majorRepo) {
        this.majorRepo = majorRepo;
    }

    public Major addMajor(Major major){
        major.setDeleteFlag(1);
        // return majorRepo.save(major);
        return majorRepo.save(major);
    }

    public List<Major> findAllMajor(){
        return majorRepo.findAllMajors();
    }

    public Major updateMajor(Major major){
        major.setDeleteFlag(1);
        return majorRepo.save(major);
    }

    public Major findMajorByMajorId(Long majorId){
        return majorRepo.findByMajorId(majorId)
                .orElseThrow(() -> new NotFoundException("Major by id: " + majorId + " not found"));
    }

    public  Major deleteMajor(Major major){
        major.setDeleteFlag(0);
        return majorRepo.save(major);
    }

}
