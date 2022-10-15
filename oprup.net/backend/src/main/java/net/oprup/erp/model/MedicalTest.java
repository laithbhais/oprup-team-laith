package net.oprup.erp.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@NoArgsConstructor
@Entity
@Table(name="medicalTest")


public class MedicalTest implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long medicalTestId;
    private Long medicalTestNumber;
    private String medicalTestResult;
    private String procedureDate;
    private String medicalResultDate;
    private Integer deleteFlag;

    @ManyToOne(targetEntity = Employee.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "employeeId",referencedColumnName = "employeeId",nullable = false)
    private Employee employee;

    public Long getMedicalTestId() {
        return medicalTestId;
    }

    public void setMedicalTestId(Long medicalTestId) {
        this.medicalTestId = medicalTestId;
    }

    public Long getMedicalTestNumber() {
        return medicalTestNumber;
    }

    public void setMedicalTestNumber(Long medicalTestNumber) {
        this.medicalTestNumber = medicalTestNumber;
    }

    public String getMedicalTestResult() {
        return medicalTestResult;
    }

    public void setMedicalTestResult(String medicalTestResult) {
        this.medicalTestResult = medicalTestResult;
    }

    public String getProcedureDate() {
        return procedureDate;
    }

    public void setProcedureDate(String procedureDate) {
        this.procedureDate = procedureDate;
    }

    public String getMedicalResultDate() {
        return medicalResultDate;
    }

    public void setMedicalResultDate(String medicalResultDate) {
        this.medicalResultDate = medicalResultDate;
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
