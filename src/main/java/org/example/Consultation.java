package org.example;

public class Consultation implements Service {
    @Override
    public double returnServiceAmount() {
        return 700;
    }
    public String returnServiceName() {
        return "Consultation";
    }
}
