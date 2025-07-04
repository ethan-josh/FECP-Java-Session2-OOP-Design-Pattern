package org.example;

public class ServiceFactory {
    public Service getService(String serviceType) {
        if (serviceType == null)
            return null;
        switch (serviceType.toLowerCase()) {
            case "xray":
            case "x-ray":
            {
                return new XRay();
            }
            case "surgery":
            {
                return new Surgery();
            }
            case "consultation":
            {
                return new Consultation();
            }
            default:
            {
                return null;
            }
        }
    }
}
