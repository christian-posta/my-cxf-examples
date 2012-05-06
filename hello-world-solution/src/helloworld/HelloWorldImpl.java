package helloworld;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.cxf.configuration.security.AuthorizationPolicy;

import com.iona.ps.courseware.helloworld.HelloWorld;

@WebService(
		serviceName = "HelloWorldService",		
		targetNamespace = "http://www.iona.com/ps/courseware/HelloWorld",
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
