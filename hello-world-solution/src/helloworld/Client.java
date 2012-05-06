package helloworld;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import com.iona.ps.courseware.helloworld.HelloWorld;
import com.iona.ps.courseware.helloworld.HelloWorldService;

public class Client {

	private static final QName serviceName = new QName(
			"http://www.iona.com/ps/courseware/HelloWorld",
			"HelloWorldService");

	private static final String wsdlFileLocation = "./wsdl/HelloWorld.wsdl"; 
	
	public static void main(String[] args) 
	{
		
		
		// Get the URL for the WSDL file.
		URL wsdlURL = null;
		try {
			wsdlURL = new File(wsdlFileLocation).toURL();
		} catch (MalformedURLException e1) {
			System.out
					.println("Exception; cannot create a URL for the wsdl file '"
							+ wsdlFileLocation + "'.");
		}

		
		// Create a HelloWorldService object, passing it the wsdlURL and 
		// the serviceName 
		System.out.println("Creating service...");
		HelloWorldService helloWorldService = new HelloWorldService(wsdlURL,
				serviceName); 
		
		
		// Get a HelloWorld proxy object from the HelloWorldService 
		// 
		System.out.println("Getting SOAPOverHTTP endpoint...");
		HelloWorld helloWorld = helloWorldService.getPort(
				new QName("http://www.iona.com/ps/courseware/HelloWorld", "SOAPOverHTTPEndpoint"),
				HelloWorld.class );  
		
		  

		  			
		
		  
		
		
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

