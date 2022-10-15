package net.oprup.erp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="company")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long companyId;
    private String companyName;
    private String tradingName;
    private String commercialNo;
    private String commercialName;
    private String issuesCommercialRegistration;
    private String commercialRegistrationExpiry ;
    private String municipalLicenseNo;
    private String issuesMunicipalLicenseNo ;
    private String municipalLicenseNoExpiry;
    private String capitalAsPerCR;
    private String taxNo;
    private String companyLogo;
    private String activityType;
    private Integer deleteFlag;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTradingName() {
        return tradingName;
    }

    public void setTradingName(String tradingName) {
        this.tradingName = tradingName;
    }

    public String getCommercialNo() {
        return commercialNo;
    }

    public void setCommercialNo(String commercialNo) {
        this.commercialNo = commercialNo;
    }

    public String getCommercialName() {
        return commercialName;
    }

    public void setCommercialName(String commercialName) {
        this.commercialName = commercialName;
    }

    public String getIssuesCommercialRegistration() {
        return issuesCommercialRegistration;
    }

    public void setIssuesCommercialRegistration(String issuesCommercialRegistration) {
        this.issuesCommercialRegistration = issuesCommercialRegistration;
    }

    public String getCommercialRegistrationExpiry() {
        return commercialRegistrationExpiry;
    }

    public void setCommercialRegistrationExpiry(String commercialRegistrationExpiry) {
        this.commercialRegistrationExpiry = commercialRegistrationExpiry;
    }

    public String getMunicipalLicenseNo() {
        return municipalLicenseNo;
    }

    public void setMunicipalLicenseNo(String municipalLicenseNo) {
        this.municipalLicenseNo = municipalLicenseNo;
    }

    public String getIssuesMunicipalLicenseNo() {
        return issuesMunicipalLicenseNo;
    }

    public void setIssuesMunicipalLicenseNo(String issuesMunicipalLicenseNo) {
        this.issuesMunicipalLicenseNo = issuesMunicipalLicenseNo;
    }

    public String getMunicipalLicenseNoExpiry() {
        return municipalLicenseNoExpiry;
    }

    public void setMunicipalLicenseNoExpiry(String municipalLicenseNoExpiry) {
        this.municipalLicenseNoExpiry = municipalLicenseNoExpiry;
    }

    public String getCapitalAsPerCR() {
        return capitalAsPerCR;
    }

    public void setCapitalAsPerCR(String capitalAsPerCR) {
        this.capitalAsPerCR = capitalAsPerCR;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
