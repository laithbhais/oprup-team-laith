package net.oprup.erp.service;

import net.oprup.erp.model.Employee;
import net.oprup.erp.model.Experience;
import net.oprup.erp.repo.ExperienceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ExperienceService {

    private  ExperienceRepo experienceRepo;

    @Autowired
    public ExperienceService(ExperienceRepo experienceRepo) {
        this.experienceRepo = experienceRepo;
    }

    public Experience addExperience(Experience experience){
        experience.setDeleteFlag(1);
        // return experienceRepo.save(experience);
        return experienceRepo.save(experience);
    }

    public List<Experience> findAllExperience(){
        return experienceRepo.findExperienceByDeleteFlag();
    }

    public Experience updateExperience(Experience experience){
        experience.setDeleteFlag(1);
        return experienceRepo.save(experience);
    }

    public List<Experience> getExperienceByEmployeeId(Employee employee){
        return experienceRepo.findExperienceByEmployeeId(employee);
    }


    public  Experience deleteExperience(Experience experience){
        experience.setDeleteFlag(0);
        return experienceRepo.save(experience);
    }

}
