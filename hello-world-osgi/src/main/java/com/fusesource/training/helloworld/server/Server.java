package com.fusesource.training.helloworld.server;

import com.fusesource.training.helloworld.service.impl.HelloWorldImpl;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Progress FUSE Services Framework 2.2.9-fuse-01-00
 * Wed Aug 25 15:08:13 EDT 2010
 * Generated source version: 2.2.9-fuse-01-00
 * 
 */
 
public class Server {

    protected Server() throws Exception {
        System.out.println("Starting Server");
        Object implementor = new HelloWorldImpl();
        String address = "http://localhost:8886/helloworld";
        Endpoint.publish(address, implementor);
    }
    
    public static void main(String args[]) throws Exception { 
        new Server();
        System.out.println("Server ready..."); 
        
        Thread.sleep(5 * 60 * 1000); 
        System.out.println("Server exiting");
        System.exit(0);
    }
}


