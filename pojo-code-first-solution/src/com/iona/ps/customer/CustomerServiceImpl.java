package com.iona.ps.customer;

import javax.jws.WebService;

// Note that for POJO services you do not need to place annotations on the service. 
//
public class CustomerServiceImpl implements CustomerService {
    
    public Customer findCustomerByName(String firstName, String lastName) {

        System.out.println("Invoked: findCustomerByName(" + firstName + ", " + lastName + ")");
        Customer ret = new Customer();

        ret.setAge(42);
        ret.setFirstName(firstName);
        ret.setLastName(lastName);
        ret.setSkypeId(firstName + "." + lastName);
        ret.setTelephoneNumber("345345");

        return ret;
    }
}

