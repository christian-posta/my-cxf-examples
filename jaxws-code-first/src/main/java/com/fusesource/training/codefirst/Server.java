package com.fusesource.training.codefirst;

import javax.xml.ws.Endpoint;

/**
 * Created with IntelliJ IDEA.
 * User: cposta
 * Date: 5/4/12
 * Time: 2:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class Server {
    public static final String ADDRESS = "http://localhost:9000/CustomerService";

    public static void main(String[] args) {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        Endpoint.publish(ADDRESS, customerService);
        System.out.println("Listening for requests on '" + ADDRESS + "'");
    }
}
