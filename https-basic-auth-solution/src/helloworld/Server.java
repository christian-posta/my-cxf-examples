package helloworld;

import javax.xml.ws.Endpoint;

public class Server {

    private static final String address = "https://localhost:9090/helloworld";
	
	public static void main(String[] args) 
	{
		

		Object helloWorldImpl = new HelloWorldImpl(); 
		
		// Publish endpoint, using the Endpoint.publish() method with the address
		// and the implementation object as parameters.
		// 
		System.out.println("Publishing endpoint");
		Endpoint endpoint = Endpoint.create(helloWorldImpl); 
		endpoint.publish(address); //#endif
        		
		// The endpoints are now listening for requests; The main thread will 
		// complete, but the Bus threads will continue to process requests.
		//
		System.out.println("Listening for requests...");
	}
}


