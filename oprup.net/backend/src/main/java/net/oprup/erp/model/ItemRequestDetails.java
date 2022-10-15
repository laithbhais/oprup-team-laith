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

@Table(name="itemRequestDetails")
public class ItemRequestDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemRequestDetailsId", nullable = false, updatable = false)
    private long itemRequestDetailsId;
    private String quantityPackage;
    private String Quantity;

    public String getQuantityPackage() {
        return quantityPackage;
    }

    public void setQuantityPackage(String quantityPackage) {
        this.quantityPackage = quantityPackage;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    @ManyToOne(targetEntity = ItemRequest.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "itemRequestId",referencedColumnName = "itemRequestId",nullable = false, updatable = true)
    private ItemRequest itemRequest;

    @ManyToOne(targetEntity = Items.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "itemsId",referencedColumnName = "itemsId",nullable = false, updatable = true)
    private Items items;

    private Integer deleteFlag;

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public long getItemRequestDetailsId() {
        return itemRequestDetailsId;
    }

    public void setItemRequestDetailsId(long itemRequestDetailsId) {
        this.itemRequestDetailsId = itemRequestDetailsId;
    }

    public ItemRequest getItemRequest() {
        return itemRequest;
    }

    public void setItemRequest(ItemRequest itemRequest) {
        this.itemRequest = itemRequest;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }
}
