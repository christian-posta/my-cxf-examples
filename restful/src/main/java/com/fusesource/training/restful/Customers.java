package com.fusesource.training.restful;

import java.util.List;
import java.util.ArrayList;

// Note: you must annotate classes to be marshalled as XML with jax-b annotations.
@javax.xml.bind.annotation.XmlRootElement
public class Customers {

	@javax.xml.bind.annotation.XmlElement(required = true)
	protected List<Customer> customer;
	
	public Customers() { 
		customer = new ArrayList<Customer>(); 
	}
	
	public List<Customer> getCustomer() {
		return customer;
	}

}


