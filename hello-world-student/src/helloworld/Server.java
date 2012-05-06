package helloworld;

import javax.xml.ws.Endpoint;

public class Server {
	 
    private static final String address = "http://localhost:9090/helloworld";
	
	public static void main(String[] args) 
	{
		

		// TODO: Create the HelloWorldImpl object.  
		// Create implementation object
		//
        HelloWorldImpl helloWorld = new HelloWorldImpl();
		
		
		// TODO: Publish endpoint. 
		// Publish endpoint, using the Endpoint.publish() method with the address
		// and the implementation object as parameters.
		//
        Endpoint.publish(address, helloWorld);
        		
		// The endpoints are now listening for requests; The main thread will 
        // complete, but the Bus threads will continue to process requests.
        //
		System.out.println("Listening for requests...");
	}
}


