package net.oprup.erp.service;

import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.JobTitle;
import net.oprup.erp.repo.JobTitleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class JobTitleService {

    private  JobTitleRepo jobTitleRepo;

    @Autowired
    public JobTitleService(JobTitleRepo jobTitleRepo) {
        this.jobTitleRepo = jobTitleRepo;
    }

    public JobTitle addJobTitle(JobTitle jobTitle){
        jobTitle.setDeleteFlag(1);
        // return jobTitleRepo.save(jobTitle);
        return jobTitleRepo.save(jobTitle);
    }

    public List<JobTitle> findAllJobTitle(){
        return jobTitleRepo.findAllJobTitles();
    }

    public JobTitle updateJobTitle(JobTitle jobTitle){
        jobTitle.setDeleteFlag(1);
        return jobTitleRepo.save(jobTitle);
    }

    public JobTitle findJobTitleByJobTitleId(Long jobTitleId){
        return jobTitleRepo.findByJobTitleId(jobTitleId)
                .orElseThrow(() -> new NotFoundException("JobTitle by id: " + jobTitleId + " not found"));
    }

    public  JobTitle deleteJobTitle(JobTitle jobTitle){
        jobTitle.setDeleteFlag(0);
        return jobTitleRepo.save(jobTitle);
    }

}
