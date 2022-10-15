package net.oprup.erp.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="insuranceCompany")
public class InsuranceCompany implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long insuranceCompanyId;
    private String insuranceCompanyName;
    private String insuranceCompanyDescription;
    private Integer deleteFlag;

    public Long getInsuranceCompanyId() {
        return insuranceCompanyId;
    }

    public void setInsuranceCompanyId(Long insuranceCompanyId) {
        this.insuranceCompanyId = insuranceCompanyId;
    }

    public String getInsuranceCompanyName() {
        return insuranceCompanyName;
    }

    public void setInsuranceCompanyName(String insuranceCompanyName) {
        this.insuranceCompanyName = insuranceCompanyName;
    }

    public String getInsuranceCompanyDescription() {
        return insuranceCompanyDescription;
    }

    public void setInsuranceCompanyDescription(String insuranceCompanyDescription) {
        this.insuranceCompanyDescription = insuranceCompanyDescription;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
