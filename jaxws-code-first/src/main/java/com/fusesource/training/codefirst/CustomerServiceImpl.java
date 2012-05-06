package com.fusesource.training.codefirst;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created with IntelliJ IDEA.
 * User: cposta
 * Date: 5/4/12
 * Time: 2:36 PM
 * To change this template use File | Settings | File Templates.
 */
@WebService(targetNamespace = "http://com.fusesource.ps/services/Customer",
            endpointInterface = "com.fusesource.training.codefirst.CustomerService",
            portName="SOAPOverHTTP",
            serviceName = "CustomerService")

public class CustomerServiceImpl implements CustomerService{
    @Override
    public Customer findCustomerByName(@WebParam(name = "firstName") String firstName, @WebParam(name = "lastName") String lastName) {
        System.out.println("findCustomerByName() invoked with firstName: " + firstName + "and lastName: " + lastName);
        Customer customer = new Customer();
        customer.setAge(42);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setSkypeId(firstName + ". " + lastName);
        customer.setTelephoneNumber("555-5555");

        return customer;
    }
}
