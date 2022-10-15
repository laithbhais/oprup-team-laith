package net.oprup.erp.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@NoArgsConstructor
@Entity
@Table(name="residence")


public class Residence implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long residenceId;
    private Long residenceNumber;
    private String jobBYResidence;
    private String residenceIssueDate;
    private String residenceExpiryDate;
    private String sponsorTransferDate;
    private String HijriSponsorTransferDate;
    private Integer deleteFlag;

    @ManyToOne(targetEntity = Employee.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "employeeId",referencedColumnName = "employeeId",nullable = false)
    private Employee employee;

    public Long getResidenceId() {
        return residenceId;
    }

    public void setResidenceId(Long residenceId) {
        this.residenceId = residenceId;
    }

    public Long getResidenceNumber() {
        return residenceNumber;
    }

    public void setResidenceNumber(Long residenceNumber) {
        this.residenceNumber = residenceNumber;
    }

    public String getJobBYResidence() {
        return jobBYResidence;
    }

    public void setJobBYResidence(String jobBYResidence) {
        this.jobBYResidence = jobBYResidence;
    }

    public String getResidenceIssueDate() {
        return residenceIssueDate;
    }

    public void setResidenceIssueDate(String residenceIssueDate) {
        this.residenceIssueDate = residenceIssueDate;
    }

    public String getResidenceExpiryDate() {
        return residenceExpiryDate;
    }

    public void setResidenceExpiryDate(String residenceExpiryDate) {
        this.residenceExpiryDate = residenceExpiryDate;
    }

    public String getSponsorTransferDate() {
        return sponsorTransferDate;
    }

    public void setSponsorTransferDate(String sponsorTransferDate) {
        this.sponsorTransferDate = sponsorTransferDate;
    }

    public String getHijriSponsorTransferDate() {
        return HijriSponsorTransferDate;
    }

    public void setHijriSponsorTransferDate(String hijriSponsorTransferDate) {
        HijriSponsorTransferDate = hijriSponsorTransferDate;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
