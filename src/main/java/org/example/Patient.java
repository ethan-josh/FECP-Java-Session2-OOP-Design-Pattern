package org.example;

public class Patient {
    private String name;
    private String insuranceType;
    private double totalBill;

    public Patient(String name, String insuranceType) {
        this.name = name;
        this.insuranceType = insuranceType;
    }
    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }
}
