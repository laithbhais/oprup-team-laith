package net.oprup.erp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="employeeInsuranceCompany")
public class EmployeeInsuranceCompany implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeInsuranceCompanyId", nullable = false, updatable = false)


    private Long employeeInsuranceCompanyId;
    private Integer deleteFlag;
    private String insurancePolicyNumber ;
    private String insurancePolicyType ;
    private String issueDate;
    private String expiryDate;
    private String insuranceDegree;

    @ManyToOne(targetEntity = InsuranceCompany.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "insuranceCompanyId",referencedColumnName = "insuranceCompanyId",nullable = false)
    private InsuranceCompany insuranceCompany;


    @ManyToOne(targetEntity = Employee.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "employeeId",referencedColumnName = "employeeId",nullable = false)
    private Employee employee;

    public Long getEmployeeInsuranceCompanyId() {
        return employeeInsuranceCompanyId;
    }

    public void setEmployeeInsuranceCompanyId(Long employeeInsuranceCompanyId) {
        this.employeeInsuranceCompanyId = employeeInsuranceCompanyId;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public void setInsurancePolicyNumber(String insurancePolicyNumber) {
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public String getInsurancePolicyType() {
        return insurancePolicyType;
    }

    public void setInsurancePolicyType(String insurancePolicyType) {
        this.insurancePolicyType = insurancePolicyType;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getInsuranceDegree() {
        return insuranceDegree;
    }

    public void setInsuranceDegree(String insuranceDegree) {
        this.insuranceDegree = insuranceDegree;
    }

    public InsuranceCompany getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}