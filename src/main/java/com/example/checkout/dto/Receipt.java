package com.example.checkout.dto;

import java.math.BigDecimal;
import java.util.List;

public class Receipt {
    private List<ReceiptItem> items;
    private BigDecimal totalBeforeDiscounts;
    private BigDecimal totalDiscount;
    private BigDecimal totalAfterDiscounts;

    public Receipt() {}

    public Receipt(List<ReceiptItem> items, BigDecimal totalBeforeDiscounts, BigDecimal totalDiscount, BigDecimal totalAfterDiscounts) {
        this.items = items;
        this.totalBeforeDiscounts = totalBeforeDiscounts;
        this.totalDiscount = totalDiscount;
        this.totalAfterDiscounts = totalAfterDiscounts;
    }

    public List<ReceiptItem> getItems() {
        return items;
    }

    public void setItems(List<ReceiptItem> items) {
        this.items = items;
    }

    public BigDecimal getTotalBeforeDiscounts() {
        return totalBeforeDiscounts;
    }

    public void setTotalBeforeDiscounts(BigDecimal totalBeforeDiscounts) {
        this.totalBeforeDiscounts = totalBeforeDiscounts;
    }

    public BigDecimal getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(BigDecimal totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public BigDecimal getTotalAfterDiscounts() {
        return totalAfterDiscounts;
    }

    public void setTotalAfterDiscounts(BigDecimal totalAfterDiscounts) {
        this.totalAfterDiscounts = totalAfterDiscounts;
    }
}
