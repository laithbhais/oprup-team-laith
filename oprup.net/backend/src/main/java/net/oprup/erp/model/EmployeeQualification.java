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
@Table(name="employeeQualification")
public class EmployeeQualification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeQualificationId", nullable = false, updatable = false)

    private Long employeeQualificationId;
    private Integer deleteFlag;
    @ManyToOne(targetEntity = Qualification.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "qualificationId",referencedColumnName = "qualificationId",nullable = false)
    private Qualification qualification;

    @ManyToOne(targetEntity = University.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "universityId",referencedColumnName = "universityId",nullable = false)
    private University university;

    @ManyToOne(targetEntity = Major.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "majorId",referencedColumnName = "majorId",nullable = false)
    private Major major;


    @ManyToOne(targetEntity = Employee.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "employeeId",referencedColumnName = "employeeId",nullable = false)
    private Employee employee;

    public Long getEmployeeQualificationId() {
        return employeeQualificationId;
    }

    public void setEmployeeQualificationId(Long employeeQualificationId) {
        this.employeeQualificationId = employeeQualificationId;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}