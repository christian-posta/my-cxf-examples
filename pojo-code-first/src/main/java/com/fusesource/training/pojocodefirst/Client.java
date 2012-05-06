package com.fusesource.training.pojocodefirst;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.cxf.frontend.ClientProxyFactoryBean;

public class Client 
{
    
    public static void main(String[] args) {
        
        // In the non-JAXWS "simple front-end", we use a ClientProxyFactoryBean to
        // create proxies to unannotated POJO services
        //
        ClientProxyFactoryBean proxyFactory = new ClientProxyFactoryBean();
        
        
        // Use the setServiceClass() operation on the proxyFactory to set
        // the interface of the service, in this case, CustomerService.class 
        proxyFactory.setServiceClass(CustomerService.class); 
        
        // Use the setAddress() operation on the proxyFactory to set
        // the address of the service. Hint: we have stored the address the service will be listening on 
        // in the public static field "ADDRESS"  of the Server class.         
        proxyFactory.setAddress(Server.ADDRESS); 
        
        
        CustomerService customerService = null; 
        // Use the create() operation on the proxyFactory to create a proxy
        // to the CustomerService. Cast the result to a CustomerService and store in
        // the customerService object declared above.     
        customerService = (CustomerService)proxyFactory.create(); 

        
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

