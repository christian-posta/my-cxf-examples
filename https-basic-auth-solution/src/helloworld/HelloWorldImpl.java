package helloworld;

import java.util.Collection;

import javax.annotation.Resource;
import javax.jws.WebService;
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

		System.out.println("sayHello(" + message + ")");

		 
		// Get a MessageContext from the WebServiceContext and store it in
		// the variable messageContext.
		//
		MessageContext messageContext = null; 	 
		messageContext = context.getMessageContext(); 

		 
		// Get the AuthorizationPolicy from the message context, using the get() method as follows:
		//
		//    messageContext.get("org.apache.cxf.configuration.security.AuthorizationPolicy");
		//
		// Cast the results to an AuthorizationPolicy, and store it in the authorizationPolicy
		// variable below.
		//  
		AuthorizationPolicy authorizationPolicy = null;  
		authorizationPolicy = (AuthorizationPolicy) messageContext.get("org.apache.cxf.configuration.security.AuthorizationPolicy"); 

		
		if (authorizationPolicy == null) {
			System.out.println("No CXF authorization information present!");
		}
		else { 
			 
			// Print out the username and password, using the getUserName() and
			// getPassword() methods on the authorizationPolicy object.
			//  
			System.out.println("Username = " + authorizationPolicy.getUserName());
			System.out.println("Password = " + authorizationPolicy.getPassword()); 
			
		} 

		  


		  

		  

		response = "Hello to you too!";

		// Return the response String
		return response;
	}
}
