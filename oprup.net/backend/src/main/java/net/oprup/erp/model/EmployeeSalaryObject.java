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
@Table(name="employeeSalaryObject")
public class EmployeeSalaryObject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeSalaryObjectId", nullable = false, updatable = false)

    private Long employeeSalaryObjectId;
    private Integer deleteFlag;
    @ManyToOne(targetEntity = SalaryObject.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "salaryObjectId", referencedColumnName = "salaryObjectId", nullable = false)
    private SalaryObject salaryObject;


    @ManyToOne(targetEntity = Employee.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId", nullable = false)
    private Employee employee;

    public Long getEmployeeSalaryObjectId() {
        return employeeSalaryObjectId;
    }

    public void setEmployeeSalaryObjectId(Long employeeSalaryObjectId) {
        this.employeeSalaryObjectId = employeeSalaryObjectId;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public SalaryObject getSalaryObject() {
        return salaryObject;
    }

    public void setSalaryObject(SalaryObject salaryObject) {
        this.salaryObject = salaryObject;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}