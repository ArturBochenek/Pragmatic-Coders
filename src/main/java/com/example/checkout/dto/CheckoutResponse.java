package com.example.checkout.dto;

public class CheckoutResponse {
    private String message;
    private double total;

    public CheckoutResponse(String message, double total) {
        this.message = message;
        this.total = total;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}
