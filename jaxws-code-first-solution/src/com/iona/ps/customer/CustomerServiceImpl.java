package com.iona.ps.customer;

import javax.jws.WebService;


// Add the @javax.jws.WebService annotation, specifying the targetNamespace
// that will be used for the physical part of the WSDL contract.
// Provide also the endpointInterface, the serviceName and portName attributes.
// 
@WebService (
             endpointInterface = "com.iona.ps.customer.CustomerService",
             targetNamespace="http://com.iona.ps/services/Customer",
             serviceName="CustomerService",
             portName="SOAPOverHTTP"
) 
public class CustomerServiceImpl implements CustomerService {
	
	public Customer findCustomerByName(String firstName, String lastName) {
		System.out.println("findCustomerByName() invoked with firstName = " + firstName + " and lastName = " + lastName + ".");
		Customer ret = new Customer();

		ret.setAge(42);
		ret.setFirstName(firstName);
		ret.setLastName(lastName);
		ret.setSkypeId(firstName + "." + lastName);
		ret.setTelephoneNumber("345345");

		return ret;
	}
}

