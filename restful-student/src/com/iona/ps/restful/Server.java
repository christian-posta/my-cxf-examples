package com.iona.ps.restful;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

public class Server {
    private static final String ADDRESS = "http://localhost:9000/";

	public static void main(String[] args) {

		 JAXRSServerFactoryBean sf  = new JAXRSServerFactoryBean();
		 sf.setServiceBean(new CustomerService());
		 sf.setAddress(ADDRESS);
		 sf.create();

		System.out.println("Listening on " + ADDRESS);
	}
}

