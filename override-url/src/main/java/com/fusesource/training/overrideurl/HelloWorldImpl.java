package com.fusesource.training.overrideurl;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.cxf.configuration.security.AuthorizationPolicy;

import com.fusesource.ps.courseware.helloworld.HelloWorld;

@WebService(
		serviceName = "HelloWorldService",		
		targetNamespace = "http://fusesource.com/ps/courseware/HelloWorld",
		wsdlLocation = "./wsdl/HelloWorld.wsdl",
		portName = "SOAPOverHTTPEndpoint"
)
public class HelloWorldImpl implements HelloWorld 
{	
	 
	// Declare a javax.xml.ws.WebServiceContext as a resource using the 
	// @Resource annotation. This is called "resource injection", a new feature
	// in Java 1.5. You do not need to initialise the resource in your 
	// contructor or static initialisers; the @Resource tag takes care of this.
	// 
	// Uncomment the following two lines of code: 
	// 
	//  @Resource
	//  private WebServiceContext context;
	//  
	@Resource
	private WebServiceContext context; 
		
	public HelloWorldImpl()
	{
	}
	
	public String sayHello(String message) 
	{
		String response = "";

						
		// Print out the message argument 
		// 
		System.out.println("sayHello(" + message + ")"); 		
		
		 	
		// Get a MessageContext from the WebServiceContext and store it in
		// the variable messageContext. 
		//
		MessageContext messageContext = null; 	 
		messageContext = context.getMessageContext();



        System.out.println("Looks like the URI might not be in the context. Here are the values:");

        for (Object o : messageContext.keySet()) {
            System.out.print(o);
            System.out.print(":");
            System.out.println(messageContext.get(o));
        }
			  
			

				
		// Set the response String 
		// 
		response = "Hello to you too!"; 
		
		// Return the response String
		return response;		
	}
}
