package net.oprup.erp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.oprup.erp.model.SubCategory;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

@Table(name="items")

public class Items implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemsId", nullable = false, updatable = false)
    private long itemsId;
    private String itemCode;
    private String itemName;
    private String itemNameEn;
    private String img;
    private String quantity;
    @Column(unique = true)
    private String barCode;
    private String countryOfOrigin;
    private String price;
    private String tax;
    private LocalDate expiryDate;
    private String sellingPrice;
    private String buyingPrice;
    private String lastBuyingPrice;
    private String taxFree;
    private Integer deleteFlag;


    @ManyToOne(targetEntity = SubCategory.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "subcategoryId",referencedColumnName = "subcategoryId",nullable = false, updatable = true)
    private SubCategory subCategory;

    @ManyToOne(targetEntity = Category.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId",referencedColumnName = "categoryId",nullable = false, updatable = true)
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne(targetEntity = Unit.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "unitId",referencedColumnName = "unitId",nullable = false, updatable = true)
    private Unit unit;

    @ManyToOne(targetEntity = Vendor.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "vendorId",referencedColumnName = "vendorId",nullable = false, updatable = true)
    private Vendor vendor;

    public String getItemNameEn() {
        return itemNameEn;
    }

    public void setItemNameEn(String itemNameEn) {
        this.itemNameEn = itemNameEn;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTaxFree() {
        return taxFree;
    }

    public void setTaxFree(String taxFree) {
        this.taxFree = taxFree;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public long getItemsId() {
        return itemsId;
    }

    public void setItemsId(long itemsId) {
        this.itemsId = itemsId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }





    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate.plusDays(1);
    }

    public String getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(String buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public String getLastBuyingPrice() {
        return lastBuyingPrice;
    }

    public void setLastBuyingPrice(String lastBuyingPrice) {
        this.lastBuyingPrice = lastBuyingPrice;
    }



    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
