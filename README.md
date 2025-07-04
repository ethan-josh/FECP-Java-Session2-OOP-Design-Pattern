

## Project Title: Hospital Billing System

This project is a Hospital Billing System that asks the user to register a patient with Option 1.    
The user will then add services that this patient has availed through Option 2.    
The user will select Option 3 to compute the total bill with corresponding discounts or none.

#### Strategy

*Insurance.java*

In this class, the ```DiscountStrategy``` is the interface that defines the ```applyDiscount (double cost)``` method. All discount types we offer implements this interface.

This makes them interchangeable which is the description of the Strategy design pattern.

Insurance.java  
<br/>|___ CashDiscount  
<br/>|___ DiscountFactory  
<br/>|___ HMODiscount  
<br/>|___Insurance  
<br/>|___NoDiscount  
<br/>|___SeniorDiscount


### Factory

*Service.java*

The factory design pattern is used to create objects without specifying the exact class of object that will be created.    
For every service type offered, they will implement the ```Service``` interface. With this, the code would not be cluttered because object creation is centralized.

Service.java ---> ServiceFactory.java  
<br/>&emsp;&emsp;&emsp;&emsp;|___ XRay.java  
<br/>&emsp;&emsp;&emsp;&emsp;|___ Surgery.java  
<br/>&emsp;&emsp;&emsp;&emsp;|___ Consultation.java

*Output* <img src="https://github.com/ethan-josh/FECP-Java-Session2-OOP-Design-Pattern/blob/main/screenshot_output.png"/>    
*Unit testing:* <img src="https://github.com/ethan-josh/FECP-Java-Session2-OOP-Design-Pattern/blob/main/screenshot_coverage.png"/>    
<img src="https://github.com/ethan-josh/FECP-Java-Session2-OOP-Design-Pattern/blob/main/screenshot_testcases.png"/>