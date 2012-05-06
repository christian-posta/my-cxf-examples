package com.iona.ps.customer;

import javax.xml.ws.Endpoint;

public class Server {
    
    public static final String ADDRESS = "http://localhost:9000/CustomerService";

    public static void main(String[] args) {        
        // Create the implementation object for the service. 
        //
        CustomerServiceImpl impl = new CustomerServiceImpl();
        
        
        // Use the Endpoint.publish() method, passing in the ADDRESS above as the
        // first parameter and the impl object as the second. 
        // 
        Endpoint.publish(ADDRESS, impl); 
        
        System.out.println("Listening for requests on '" + ADDRESS + "'");

    }

}

