package com.example.checkout.dto;

import java.math.BigDecimal;

public class ReceiptItem {
    private String productId;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal subtotalBefore;
    private BigDecimal subtotalAfter;
    private BigDecimal discount;

    public ReceiptItem() {}

    public ReceiptItem(String productId, int quantity, BigDecimal unitPrice, BigDecimal subtotalBefore, BigDecimal subtotalAfter, BigDecimal discount) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotalBefore = subtotalBefore;
        this.subtotalAfter = subtotalAfter;
        this.discount = discount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getSubtotalBefore() {
        return subtotalBefore;
    }

    public void setSubtotalBefore(BigDecimal subtotalBefore) {
        this.subtotalBefore = subtotalBefore;
    }

    public BigDecimal getSubtotalAfter() {
        return subtotalAfter;
    }

    public void setSubtotalAfter(BigDecimal subtotalAfter) {
        this.subtotalAfter = subtotalAfter;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
