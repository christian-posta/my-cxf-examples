package com.fusesource.training.overrideurl;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import com.fusesource.ps.courseware.helloworld.HelloWorld;
import com.fusesource.ps.courseware.helloworld.HelloWorldService;

public class Client {

	private static final QName serviceName = new QName(
			"http://fusesource.com/ps/courseware/HelloWorld",
			"HelloWorldService");

	private static final String wsdlFileLocation = "/wsdl/HelloWorld.wsdl";
	
	public static void main(String[] args) 
	{
		
		
		// Get the URL for the WSDL file.
        URL wsdlURL = Client.class.getResource(wsdlFileLocation);


        // Create a HelloWorldService object, passing it the wsdlURL and
		// the serviceName 
		System.out.println("Creating service...");
		HelloWorldService helloWorldService = new HelloWorldService(wsdlURL,
				serviceName); 
		
		
		// Get a HelloWorld proxy object from the HelloWorldService 
		// 
		System.out.println("Getting SOAPOverHTTP endpoint...");
		HelloWorld helloWorld = helloWorldService.getPort(
				new QName("http://fusesource.com/ps/courseware/HelloWorld", "SOAPOverHTTPEndpoint"),
				HelloWorld.class );  
		
		 
		// Get the request context. You can do this by casting the helloWorld
		// proxy object to a BindingProvider, and then calling the 
		// getRequestContext() method. This will return a Map<String, Object>.  
		//  		
		Map<String, Object> requestContext = ((BindingProvider) helloWorld)
				.getRequestContext(); 

		  
		// Override the URL for the helloworld proxy. To do this, put an entry
		// using the key BindingProvider.ENDPOINT_ADDRESS_PROPERTY into the 
		// request context map. Use the address "http://localhost:9021/helloworld"
		// When you're done, modify the server so that it listens
		// on the same endpoint address.
		//  
		requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://localhost:9021/helloworld");
		
		  
		
		
		// Invoke sayHello() on your proxy object, passing in a String
		// parameter and printing out the returned String. 
		// 
		System.out.println("Invoking sayHello");
		String response = helloWorld.sayHello("Hello!");
		System.out.println("Result = '" + response + "'"); 

		
		// Shutdown gracefully; we have to explicitly use System.exit()  
		// so that any daemon threads created by the underlying bus will get 
		// terminated; if we don't do this then the threads will continue  
		// running and the program will hang after the main thread (this one!) 
		// has been finished. 
		//
		System.exit(0);		
	}
}

