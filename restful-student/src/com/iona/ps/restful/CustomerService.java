package com.iona.ps.restful;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;


// TODO: Annotate the service interface. 
// For a RESTful service, you should annotate the interface using the @javax.ws.rs.Path annotation.
// Additionaly, you can list the supported Content types using the @javax.ws.rs.ProduceMime annotation.
//
@Path("/customerservice")
public class CustomerService {
	
	private int idCounter;
    
    // Get a customer by ID.
    
    // TODO: Annotate the operation with @javax.ws.rs.GET. 
    
    @GET
    // TODO: Specify the sub-path using the @Path annotation. 
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
	 
     // TODO: Specify the HTTP operation to be a GET using the @GET annotation. 
	  
	@GET
	 // TODO: Specify the sub path for the search query to be "/customers/search" using the @Path annotation 
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
	 
     // TODO: Specify the HTTP operation to be a POST using the @POST annotation. 
	@POST
	 
     // TODO: Specify the subpath to be "/customers" using the @Path annotation. 
	@Path("/customers")
	 public Response addCustomer(Customer customer) {
	 	System.out.println("Creating new customer, details:" 
	 		 + customer);
			 
		Response response = null;
		
		
		// TODO: Create an 'ok' response containing the ID of the message created (increment the idCounter) . 
		
	 	response = Response.ok("" + idCounter ++).build(); 
		
		return response;
	 }
	 
	 // Update a customer
	 
     // TODO: Specify the HTTP operation to be a PUT using the @PUT annotation. 
	@PUT
	 
     // TODO: Specify the sub-path to be "/customers/{id}/" using the @Path annotation 
	@Path("/customers/{id}")
	 public Response updateCustomer(@PathParam("id") String id, Customer customer) {
	 	System.out.println("Updating customer with id " + id +
	          ", details: \n " + customer);
			  
		Response response = null;
		
		
		// TODO: Create an 'ok' response. 
		
	 	response = Response.ok().build(); 	
		
		return response;
	 }
	 
	 
     // TODO: Specify the HTTP operation to be a DELETE using the @DELETE annotation. 
	@DELETE
	 
     // TODO: Specify the sub-path to be "/customers/{id}/" using the @Path annotation 
	@Path("/customers/{id}")
	 public Response deleteCustomer(@PathParam("id") String id) {
	 	System.out.println("Deleting customer with id " + id );
		
		Response response = null; 
		
		// TODO: Create an 'ok' response. 
		
	 	response = Response.ok().build();  
		
		return response;
	 }
}

