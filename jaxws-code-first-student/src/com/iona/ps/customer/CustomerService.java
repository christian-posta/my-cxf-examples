package com.iona.ps.customer;


import javax.jws.WebParam;
import javax.jws.WebService;

// TODO: Annotate the Service Endpoint Interface (SEI)
// Add the @javax.jws.WebService annotation, specifying the targetNamespace 
// that will be used for the logical part of the WSDL contract. 
// In this case, use: 
//
//      targetNamespace="http://com.iona.ps/services/Customer"
//
@WebService(name ="CustomerService", targetNamespace = "http://com.iona.ps/services/Customer")
public interface CustomerService {

    
    // TODO: Annotate the parameters 
    // Annotate each parameter, providing a @javax.jws.WebParam annotation that 
    // specifies the parameter name to be used in the WSDL. This will prevent the occurrence
    // of useless parameter names like arg0 and arg1.  
    // 
    Customer findCustomerByName(
         @WebParam(name = "firstName")
         String firstName, 

         @WebParam(name = "lastName")
         String lastName
    );
}

