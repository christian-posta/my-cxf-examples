package com.iona.ps.restful;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;


// For a RESTful service, you should annotate the interface using the @javax.ws.rs.Path annotation.
// Additionaly, you can list the supported Content types using the @javax.ws.rs.ProduceMime annotation.
//        
@Path("/customerservice")
@Produces("application/xml")
public class CustomerService {
	
	private int idCounter;
    
    // Get a customer by ID.
    
      
    @GET 
    
      
    @Path("/customers/{id}") 
    public Customer getCustomer(@PathParam("id") String id) {
    	Customer c = new Customer();
    	c.setId(id);
    	c.setAge(35);
    	c.setFirstName("Joe");
    	c.setLastName("Bloggs");
    	return c; 
    }

	 // Search for a customer by first name last name
	 // 
	 
	 
	 @GET  
	 
	 
	 @Path("/customers/search") 
	 public Customers getCustomer(
			 @QueryParam ("firstName") String firstName,
			 @QueryParam("lastName") String lastName ) 
	 {
	 	System.out.println("Searching for customer " + firstName + " " + lastName);
		
		Customers ret = new Customers();
		
    	Customer c = new Customer();
    	c.setId("123");
    	c.setAge(35);
    	c.setFirstName(firstName);
    	c.setLastName(lastName);
		
		ret.getCustomer().add(c);
	 	return ret; 
	 }
	 
	 // Add a customer
	 
	 	 
	 @POST  
	 
	 	
	 @Path("/customers") 
	 public Response addCustomer(Customer customer) {
	 	System.out.println("Creating new customer, details:" 
	 		 + customer);
			 
		Response response = null;
		
		
		
		
		return response;
	 }
	 
	 // Update a customer
	 
	 		 
	 @PUT 
	 
	 	
	 @Path("/customers/{id}/")  
	 public Response updateCustomer(@PathParam("id") String id, Customer customer) {
	 	System.out.println("Updating customer with id " + id +
	          ", details: \n " + customer);
			  
		Response response = null;
		
		
			
		
		return response;
	 }
	 
	 
	 
	 @DELETE 
	 
	 	
	 @Path("/customers/{id}/") 
	 public Response deleteCustomer(@PathParam("id") String id) {
	 	System.out.println("Deleting customer with id " + id );
		
		Response response = null; 
		
		
		
		return response;
	 }
}

