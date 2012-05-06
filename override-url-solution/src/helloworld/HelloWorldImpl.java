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
		
		   
		
		
			  
			

				
		// Set the response String 
		// 
		response = "Hello to you too!"; 
		
		// Return the response String
		return response;		
	}
}
