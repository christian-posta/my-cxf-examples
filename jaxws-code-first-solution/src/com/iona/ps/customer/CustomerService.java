package com.iona.ps.customer;



// Add the @javax.jws.WebService annotation, specifying the targetNamespace 
// that will be used for the logical part of the WSDL contract. 
// In this case, use: 
//
//      targetNamespace="http://com.iona.ps/services/Customer"
// 
@javax.jws.WebService (
             targetNamespace="http://com.iona.ps/services/Customer"
) 
public interface CustomerService {

    
    // Annotate each parameter, providing a @javax.jws.WebParam annotation that 
    // specifies the parameter name to be used in the WSDL. This will prevent the occurrence
    // of useless parameter names like arg0 and arg1.  
    // 
    Customer findCustomerByName(
          
         @javax.jws.WebParam(name="firstName") 
         String firstName, 
          
         @javax.jws.WebParam(name="lastName") 
         String lastName
    );
}

