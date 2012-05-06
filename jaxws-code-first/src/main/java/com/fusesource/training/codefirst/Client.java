package com.fusesource.training.codefirst;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: cposta
 * Date: 5/4/12
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Client {
    private static URL WSDL_LOCATION;
    private static String NAMESPACE = "http://com.fusesource.ps/services/Customer";

    static {
        try {
            WSDL_LOCATION = new URL(Server.ADDRESS + "?wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Unable to init WSDL location URL; details: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Service service = Service.create(WSDL_LOCATION, new QName(NAMESPACE, "CustomerService"));

        CustomerService customerService = service.getPort(new QName(NAMESPACE, "SOAPOverHTTP"), CustomerService.class);

        Customer customer = customerService.findCustomerByName("christian", "posta");

        System.out.println("Got customer; details: ");
        System.out.println("Age = " + customer.getAge());
        System.out.println("First Name = " + customer.getFirstName());
        System.out.println("Last Name = " + customer.getLastName());
        System.out.println("Skype ID = " + customer.getSkypeId());
        System.out.println("Phone = " + customer.getTelephoneNumber());
    }
}
