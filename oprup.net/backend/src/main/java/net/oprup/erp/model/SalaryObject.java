package net.oprup.erp.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="salaryObject")
public class SalaryObject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long salaryObjectId;
    private String salaryObjectName;
    private String salaryObjectDescription;
    private Integer deleteFlag;


    public Long getSalaryObjectId() {
        return salaryObjectId;
    }

    public void setSalaryObjectId(Long salaryObjectId) {
        this.salaryObjectId = salaryObjectId;
    }

    public String getSalaryObjectName() {
        return salaryObjectName;
    }

    public void setSalaryObjectName(String salaryObjectName) {
        this.salaryObjectName = salaryObjectName;
    }

    public String getSalaryObjectDescription() {
        return salaryObjectDescription;
    }

    public void setSalaryObjectDescription(String salaryDescription) {
        this.salaryObjectDescription = salaryDescription;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
