package org.example;

public class Insurance {
    public static double getFinalCost(
            String insuranceType,
            double cost
    ) {
        DiscountStrategy strategy = DiscountFactory.getStrategy(insuranceType);
        return strategy.applyDiscount(cost);
    }
}

class DiscountFactory {
    public static DiscountStrategy getStrategy(String insuranceType) {
        if (insuranceType == null) return new NoDiscount();

        return switch (insuranceType.toLowerCase()) {
            case "hmo" -> new HmoDiscount();
            case "cash" -> new CashDiscount();
            case "senior" -> new SeniorDiscount();
            default -> new NoDiscount();
        };
    }
}

interface DiscountStrategy {
    double applyDiscount(double cost);
}

class HmoDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double cost) {
        return cost * 0.85;
    }
}

class SeniorDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double cost) {
        return cost * 0.80;
    }
}

class CashDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double cost) {
        return cost * 0.90;
    }
}

class NoDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double cost) {
        return cost;
    }
}