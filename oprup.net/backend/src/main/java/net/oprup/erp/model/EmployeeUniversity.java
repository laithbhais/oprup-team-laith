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
@Table(name="employeeUniversity")
public class EmployeeUniversity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeUniversityId", nullable = false, updatable = false)



    private Long employeeUniversityId;
    private Integer deleteFlag;


    @ManyToOne(targetEntity = University.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "universityId",referencedColumnName = "universityId",nullable = false)
    private University university;


    @ManyToOne(targetEntity = Employee.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "employeeId",referencedColumnName = "employeeId",nullable = false)
    private Employee employee;


    public Long getEmployeeUniversityId() {
        return employeeUniversityId;
    }

    public void setEmployeeUniversityId(Long employeeUniversityId) {
        this.employeeUniversityId = employeeUniversityId;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
