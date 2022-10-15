package net.oprup.erp.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="topManagement")
public class TopManagement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long topManagementId;
    private String topManagementName;
    private String topManagementDescription;
    private Integer deleteFlag;

    public Long getTopManagementId() {
        return topManagementId;
    }

    public void setTopManagementId(Long topManagementId) {
        this.topManagementId = topManagementId;
    }

    public String getTopManagementName() {
        return topManagementName;
    }

    public void setTopManagementName(String topManagementName) {
        this.topManagementName = topManagementName;
    }

    public String getTopManagementDescription() {
        return topManagementDescription;
    }

    public void setTopManagementDescription(String topManagementDescription) {
        this.topManagementDescription = topManagementDescription;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
