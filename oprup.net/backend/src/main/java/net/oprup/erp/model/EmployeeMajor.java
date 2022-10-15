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
@Table(name="employeeMajor")
public class EmployeeMajor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeMajorId", nullable = false, updatable = false)

    private Long employeeMajorId;
    private Integer deleteFlag;
    @ManyToOne(targetEntity = Major.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "majorId",referencedColumnName = "majorId",nullable = false)
    private Major major;


    @ManyToOne(targetEntity = Employee.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "employeeId",referencedColumnName = "employeeId",nullable = false)
    private Employee employee;

    public Long getEmployeeMajorId() {
        return employeeMajorId;
    }

    public void setEmployeeMajorId(Long employeeMajorId) {
        this.employeeMajorId = employeeMajorId;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
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