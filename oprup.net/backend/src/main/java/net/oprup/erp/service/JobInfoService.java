package net.oprup.erp.service;

import net.oprup.erp.model.Employee;
import net.oprup.erp.model.JobInfo;
import net.oprup.erp.repo.JobInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class JobInfoService {


    private JobInfoRepo jobInfoRepo;

    @Autowired
    public JobInfoService(JobInfoRepo jobInfoRepo) {
        this.jobInfoRepo = jobInfoRepo;
    }



    public JobInfo addJobInfo(JobInfo jobInfo){
        jobInfo.setDeleteFlag(1);
        return jobInfoRepo.save(jobInfo);
    }


    public List<JobInfo> findAllJobInfo(){
        return jobInfoRepo.findJobInfoByDeleteFlag();
    }


    public JobInfo updateJobInfo(JobInfo jobInfo){
        jobInfo.setDeleteFlag(1);
        return jobInfoRepo.save(jobInfo);
    }


    public List<JobInfo> getJobInfoByEmployeeId(Employee employee){
        return jobInfoRepo.findJobInfoByEmployeeId(employee);
    }

    public  JobInfo deleteJobInfo(JobInfo jobInfo){
        jobInfo.setDeleteFlag(0);
        return jobInfoRepo.save(jobInfo);
    }


}
