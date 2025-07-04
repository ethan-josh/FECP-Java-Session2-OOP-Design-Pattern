package org.example;

public class XRay implements Service {
    @Override
    public double returnServiceAmount() {
        return 500.00;
    }
    public String returnServiceName() {
        return "X-Ray";
    }
}
