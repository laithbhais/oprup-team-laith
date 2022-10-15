package net.oprup.erp.service;

import net.oprup.erp.model.Employee;
import net.oprup.erp.model.MedicalTest;
import net.oprup.erp.repo.MedicalTestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MedicalTestService {

    private  MedicalTestRepo medicalTestRepo;

    @Autowired
    public MedicalTestService(MedicalTestRepo medicalTestRepo) {
        this.medicalTestRepo = medicalTestRepo;
    }

    public MedicalTest addMedicalTest(MedicalTest medicalTest){
        medicalTest.setDeleteFlag(1);
        // return medicalTestRepo.save(medicalTest);
        return medicalTestRepo.save(medicalTest);
    }

    public List<MedicalTest> findAllMedicalTest(){
        return medicalTestRepo.findMedicalTestByDeleteFlag();
    }

    public MedicalTest updateMedicalTest(MedicalTest medicalTest){
        medicalTest.setDeleteFlag(1);
        return medicalTestRepo.save(medicalTest);
    }

    public List<MedicalTest> getMedicalTestByEmployeeId(Employee employee){
        return medicalTestRepo.findMedicalTestByEmployeeId(employee);
    }


    public  MedicalTest deleteMedicalTest(MedicalTest medicalTest){
        medicalTest.setDeleteFlag(0);
        return medicalTestRepo.save(medicalTest);
    }

}
