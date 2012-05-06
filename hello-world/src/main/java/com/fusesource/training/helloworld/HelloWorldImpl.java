package com.fusesource.training.helloworld;

import com.fusesource.ps.courseware.helloworld.HelloWorld;

import javax.jws.WebService;

@WebService(
		serviceName = "HelloWorldService",		
		targetNamespace = "http://fusesource.com/ps/courseware/HelloWorld",
		wsdlLocation = "./wsdl/HelloWorld.wsdl",
		portName = "SOAPOverHTTPEndpoint"
)
public class HelloWorldImpl implements HelloWorld 
{	
	  
		
	public HelloWorldImpl()
	{
	}
	
	public String sayHello(String message) 
	{
		String response = "";

						
		// Print out the message argument 
		// 
		System.out.println("sayHello(" + message + ")"); 		
		
		 	 
		
		   
		
		
			  
			

				
		// Set the response String 
		// 
		response = "Hello to you too!"; 
		
		// Return the response String
		return response;		
	}
}
