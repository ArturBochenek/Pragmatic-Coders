package com.example.checkout.service;

import java.util.*;

public class CheckoutService {

    private static class ItemRule {
        double unitPrice;
        int specialQty;
        double specialPrice;
        ItemRule(double unitPrice, int specialQty, double specialPrice) {
            this.unitPrice = unitPrice;
            this.specialQty = specialQty;
            this.specialPrice = specialPrice;
        }
    }

    private static final Map<String, ItemRule> rules = new HashMap<>();
    static {
        rules.put("A", new ItemRule(40.0, 3, 30.0));
        rules.put("B", new ItemRule(10.0, 2, 7.5));
        rules.put("C", new ItemRule(30.0, 4, 20.0));
        rules.put("D", new ItemRule(25.0, 2, 23.5));
    }

    private final List<String> scanned = new ArrayList<>();

    public void scan(String product) {
        if (product != null && rules.containsKey(product)) {
            scanned.add(product);
        }
    }

    public double calculateTotal(String product, int quantity) {
        if (product == null || quantity <= 0) return 0.0;
        ItemRule rule = rules.get(product);
        if (rule == null) return 0.0;

        int specials = quantity / rule.specialQty;
        int remainder = quantity % rule.specialQty;
        double total = specials * rule.specialQty * rule.specialPrice + remainder * rule.unitPrice;
        return total;
    }

    public double getTotal() {
        Map<String, Long> counts = new HashMap<>();
        for (String s : scanned) counts.put(s, counts.getOrDefault(s, 0L) + 1);
        double total = 0.0;
        for (Map.Entry<String, Long> e : counts.entrySet()) {
            total += calculateTotal(e.getKey(), e.getValue().intValue());
        }

        if (counts.containsKey("A") && counts.containsKey("B")) total -= 5.0;

        return total;
    }

    public void checkout() {
        scanned.clear();
    }

    public String getReceipt() {
        StringBuilder sb = new StringBuilder("Receipt:\n");
        Map<String, Long> counts = new HashMap<>();
        for (String s : scanned) counts.put(s, counts.getOrDefault(s, 0L) + 1);
        for (Map.Entry<String, Long> e : counts.entrySet()) {
            sb.append(e.getKey()).append(" x").append(e.getValue())
                    .append(" = ").append(calculateTotal(e.getKey(), e.getValue().intValue())).append("\n");
        }
        sb.append("Total: ").append(getTotal());
        return sb.toString();
    }
}
