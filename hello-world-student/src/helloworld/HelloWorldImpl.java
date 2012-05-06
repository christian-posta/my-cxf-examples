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

		
		// TODO: Print a message. 				
		// Print out the message argument 
		// 		
        System.out.println("Hers the message argumetn"  + message);


		
		// TODO: Send a response. 		
		// Set the response String 
		// 
        response = "Right back acha";
		// Return the response String
		return response;		
	}
}
