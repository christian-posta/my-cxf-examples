package com.fusesource.training.helloworld.service.impl;

import com.fusesource.training.helloworld.HelloWorld;

import javax.jws.WebService;


@WebService(portName = "SOAPOverHTTPEndpoint", serviceName = "HelloWorldService", 
                      targetNamespace = "http://fusesource.com/training/HelloWorld", 
                      endpointInterface = "com.fusesource.training.helloworld.HelloWorld")
               
public class HelloWorldImpl
    implements HelloWorld {


    public HelloWorldImpl() {
    }

    public String sayHello( String message ) {
        String response = "";
        // Print out the message argument
        System.out.println( "sayHello(" + message + ")" );
        // Set the response String
        response = "Hello to " + message + ", too!";
        // Return the response String
        return response;
    }
}
