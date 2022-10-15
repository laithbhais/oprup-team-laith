package net.oprup.erp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

@Table(name="itemRequest")
public class ItemRequest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemRequestId", nullable = false, updatable = false)
    private long itemRequestId;
    private LocalDate itemRequestDate;

    private Integer deleteFlag;



    public LocalDate getItemRequestDate() {
        return itemRequestDate;
    }

    public void setItemRequestDate(LocalDate itemRequestDate) {
        this.itemRequestDate = itemRequestDate.plusDays(1);
    }


    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public long getItemRequestId() {
        return itemRequestId;
    }

    public void setItemRequestId(long itemRequestId) {
        this.itemRequestId = itemRequestId;
    }




}
