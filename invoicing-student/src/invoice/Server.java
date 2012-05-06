package invoice;

import java.util.logging.Logger;

import javax.xml.ws.Endpoint;

public class Server {

    private static final String address = "http://localhost:9090/InvoicingService";

	  

	public static void main(String[] args) 
	{
		
  
		
		
		// TODO: Create implementation object.  
		// Create implementation object using default constructor.
		// 
		InvoicingImpl service = new InvoicingImpl();
		  
		System.out.println("Publishing endpoint"); 
		
		
		// TODO: Publish the endpoint. 
		// Publish endpoint, using the Endpoint.publish() method with the address
		// and the implementation object as parameters.
		// 
		Endpoint.publish(address, service);

        		
		// The endpoints are now listenening for requests; The main thread will 
        // complete, but the Bus threads will continue to process requests.
        //
		  
		System.out.println("Listening for requests...");		
	}

}

