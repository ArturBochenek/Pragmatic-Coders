package com.examle.checkout;

import com.example.checkout.service.CheckoutService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CheckoutServiceTest {

    private CheckoutService service;

    @Before
    public void setup() {
        service = new CheckoutService();
    }

    @Test
    public void shouldReturnZeroForUnknownProduct() {
        double total = service.calculateTotal("X", 2);
        assertEquals(0.0, total, 0.001);
    }

    @Test
    public void shouldCalculateNormalPrice() {
        double total = service.calculateTotal("A", 1);
        assertEquals(40.0, total, 0.001);
    }

    @Test
    public void shouldApplySpecialPriceForA() {
        double total = service.calculateTotal("A", 3);
        assertEquals(90.0, total, 0.001);
    }

    @Test
    public void shouldApplySpecialPriceForB() {
        double total = service.calculateTotal("B", 2);
        assertEquals(15.0, total, 0.001);
    }

    @Test
    public void shouldApplySpecialPriceForD() {
        double total = service.calculateTotal("D", 2);
        assertEquals(47.0, total, 0.001);
    }

    @Test
    public void shouldHandleMixedPricingForA() {
        double total = service.calculateTotal("A", 5);
        assertEquals(150.0, total, 0.001); // 3 for 90 + 2 * 40
    }

    @Test
    public void shouldApplyBundleDiscountForAandB() {
        service.scan("A");
        service.scan("B");
        double total = service.getTotal();
        assertTrue(total < 50.0); // discount applied
    }

    @Test
    public void shouldCombineDifferentItems() {
        service.scan("A");
        service.scan("B");
        service.scan("C");
        double total = service.getTotal();
        assertTrue(total > 0);
        assertTrue(total < 100.0);
    }

    @Test
    public void shouldResetAfterCheckout() {
        service.scan("A");
        service.checkout();
        assertEquals(0.0, service.getTotal(), 0.001);
    }

    @Test
    public void shouldReturnReceiptWithAllProducts() {
        service.scan("A");
        service.scan("B");
        String receipt = service.getReceipt();
        assertTrue(receipt.contains("A"));
        assertTrue(receipt.contains("B"));
        assertTrue(receipt.contains("Total"));
    }
}
