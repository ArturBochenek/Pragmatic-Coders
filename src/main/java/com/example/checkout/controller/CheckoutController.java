package com.example.checkout.controller;

import com.example.checkout.dto.CheckoutRequest;
import com.example.checkout.dto.CheckoutResponse;
import com.example.checkout.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private final CheckoutService service = new CheckoutService();

    @PostMapping("/calculate")
    public CheckoutResponse calculate(@RequestBody CheckoutRequest request) {
        double total = service.calculateTotal(request.getProductId(), request.getQuantity());
        return new CheckoutResponse("Calculated total", total);
    }

    @PostMapping("/scan")
    public CheckoutResponse scan(@RequestBody CheckoutRequest request) {
        service.scan(request.getProductId());
        return new CheckoutResponse("Item scanned", service.getTotal());
    }

    @GetMapping("/total")
    public CheckoutResponse total() {
        return new CheckoutResponse("Current total", service.getTotal());
    }

    @PostMapping("/checkout")
    public CheckoutResponse checkout() {
        double total = service.getTotal();
        String receipt = service.getReceipt();
        service.checkout();
        return new CheckoutResponse(receipt, total);
    }
}
