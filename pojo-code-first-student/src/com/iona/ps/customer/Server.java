package com.iona.ps.customer;

import org.apache.cxf.frontend.ServerFactoryBean;

import javax.xml.ws.Endpoint;

public class Server {
    
    public static final String ADDRESS = "http://localhost:9000/CustomerService";

    public static void main(String[] args) {        
        // Create the implementation object for the service. 
        //
        CustomerServiceImpl impl = new CustomerServiceImpl();
        
        // In the non-JAXWS "simple frontend", we use a ServerFactoryBean to
        // intantiate un-annotated POJO services
        //
        ServerFactoryBean serviceFactory = new ServerFactoryBean();
        
        
        // TODO: Set the service class 
        // Use the setServiceClass() operation on the serviceFactory to set
        // the service interface, in this case, CustomerService.class
        serviceFactory.setServiceClass(CustomerService.class);
        
        // TODO: Set the service address 
        // Use the setAddress() operation on the serviceFactory to set
        // the service endpoint address, in this case, the ADDRESS url declared above
        serviceFactory.setAddress(ADDRESS);
        
        // TODO: Set the service implementation 
        // Use the setServiceBean() operation on the serviceFactory to set
        // the service implementation object, in this case, the impl object declared above.
        serviceFactory.setServiceBean(impl);
        
        // TODO: Create the service 
        // Use the create() operation on the serviceFactory to publish the service and 
        // start listening for requests.
        serviceFactory.create();

        System.out.println("Listening for requests on '" + ADDRESS + "'");

    }

}

