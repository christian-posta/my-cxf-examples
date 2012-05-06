package com.fusesource.training.pojocodefirst;

import org.apache.cxf.frontend.ServerFactoryBean;

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
        
        
        // Use the setServiceClass() operation on the serviceFactory to set
        // the service interface, in this case, CustomerService.class 
        serviceFactory.setServiceClass(CustomerService.class); 
        
        // Use the setAddress() operation on the serviceFactory to set
        // the service endpoint address, in this case, the ADDRESS url declared above        
        serviceFactory.setAddress(ADDRESS); 
        
        // Use the setServiceBean() operation on the serviceFactory to set
        // the service implementation object, in this case, the impl object declared above.                
        serviceFactory.setServiceBean(impl);
        
        // Use the create() operation on the serviceFactory to publish the service and 
        // start listening for requests.  
        serviceFactory.create(); 
        
        System.out.println("Listening for requests on '" + ADDRESS + "'");

    }

}

