package com.iona.ps.customer;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client 
{
    private static URL WSDL_LOCATION; 
    
    static {
        try {
            WSDL_LOCATION = new URL(Server.ADDRESS + "?wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Unable to initialise WSDL location URL; details: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {

        Service service = null; 
        
        // Create a service object using the static create() method on the class
        // javax.xml.ws.Service. The first parameter should be the WSDL_LOCATION from above;
        // the second parameter should be the QName of the service. Store the result in the 
        // "service" variable defined above. 
        service = Service.create(
                                 WSDL_LOCATION, 
                                 new QName("http://com.iona.ps/services/Customer",
                                           "CustomerService")); 


        
        CustomerService customerService = null;
        
        // Create a proxy for the customerService by invoking the getPort() method on the 
        // service object. The first parameter should be the QName of the port, in this case,
        //
        //     new QName("http://com.iona.ps/services/Customer", "SOAPOverHTTP")
        //
        // the second parameter should be the SEI class, that is, "CustomerService.class".
        // Store the result in the "customerService" variable defined above. 
        customerService = service.getPort(
                     new QName("http://com.iona.ps/services/Customer", "SOAPOverHTTP"),
                     CustomerService.class); 

        Customer customer = null; 
        
        // Invoke on the service using the findCustomerByName() operation. Store
        // the result in the "customer" object defined above.  
        customer = customerService.findCustomerByName("Joe", "Bloggs"); 

        System.out.println("Got customer; details: ");
        System.out.println("Age = " + customer.getAge());
        System.out.println("First Name = " + customer.getFirstName());
        System.out.println("Last Name = " + customer.getLastName());
        System.out.println("Skype ID = " + customer.getSkypeId());
        System.out.println("Phone = " + customer.getTelephoneNumber());
    }
}

