package org.example;

public class Surgery implements Service {
    @Override
    public double returnServiceAmount() {
        return 12000.00;
    }
    public String returnServiceName() {
        return "Surgery";
    }
}
