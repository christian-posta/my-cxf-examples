package com.fusesource.training.helloworld;

import javax.xml.ws.Endpoint;

public class Server {
	 
    private static final String address = "http://localhost:9090/helloworld";
	
	public static void main(String[] args) 
	{
		

		 
		// Create implementation object
		// 
		Object helloWorldImpl = new HelloWorldImpl(); 
		
		
		// Publish endpoint, using the Endpoint.publish() method with the address
		// and the implementation object as parameters.
		// 
        System.out.println("Publishing endpoint");
        Endpoint endpoint = Endpoint.create(helloWorldImpl); 
        endpoint.publish(address); 
        		
		// The endpoints are now listening for requests; The main thread will 
        // complete, but the Bus threads will continue to process requests.
        //
		System.out.println("Listening for requests...");
	}
}


