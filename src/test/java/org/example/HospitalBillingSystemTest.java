package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HospitalBillingSystemTest {

    private ServiceFactory serviceFactory;
    private Service service;

    @BeforeEach
    void setup() {
        serviceFactory = new ServiceFactory();
    }

    @Test
    public void testHmoDiscount() {
        double cost = 1000.0;
        double expected = 850.0; // 15% discount
        double actual = Insurance.getFinalCost("hmo", cost);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testSeniorDiscount() {
        double cost = 1000.0;
        double expected = 800.0; // 20% discount
        double actual = Insurance.getFinalCost("senior", cost);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testCashDiscount() {
        double cost = 1000.0;
        double expected = 900.0; // 10% discount
        double actual = Insurance.getFinalCost("cash", cost);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    void testXRayServiceTypeCreation() {
        service = serviceFactory.getService("xray");
        assertNotNull(service);
        assertEquals("X-Ray", service.returnServiceName());
        assertEquals(500, service.returnServiceAmount());
    }

    @Test
    void testSurgeryServiceTypeCreation() {
        service = serviceFactory.getService("surgery");
        assertNotNull(service);
        assertEquals("Surgery", service.returnServiceName());
        assertEquals(12000, service.returnServiceAmount());
    }

    @Test
    void testConsultationServiceTypeCreation() {
        service = serviceFactory.getService("consultation");
        assertNotNull(service);
        assertEquals("Consultation", service.returnServiceName());
        assertEquals(700, service.returnServiceAmount());
    }

    @Test
    void testUnknownServiceTypeCreation() {
        service = serviceFactory.getService("blood test");
        assertNull(service);
    }

}