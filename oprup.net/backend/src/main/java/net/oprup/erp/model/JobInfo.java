package net.oprup.erp.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@NoArgsConstructor
@Entity
@Table(name="jobInfo")
public class JobInfo implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long jobInfoId;
    private String joinDate;
    private Integer deleteFlag;


    @ManyToOne(targetEntity = Section.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "sectionId",referencedColumnName = "sectionId",nullable = false, updatable = true)
    private Section section;

    @ManyToOne(targetEntity = JobTitle.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "jobTitleId",referencedColumnName = "jobTitleId",nullable = false, updatable = true)
    private JobTitle jobTitle;

    @ManyToOne(targetEntity = Employee.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "employeeId",referencedColumnName = "employeeId",nullable = false, updatable = true)
    private Employee employee;

    public Long getJobInfoId() {
        return jobInfoId;
    }

    public void setJobInfoId(Long jobInfoId) {
        this.jobInfoId = jobInfoId;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
