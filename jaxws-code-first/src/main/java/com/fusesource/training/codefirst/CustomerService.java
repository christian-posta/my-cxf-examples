package com.fusesource.training.codefirst;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created with IntelliJ IDEA.
 * User: cposta
 * Date: 5/4/12
 * Time: 2:36 PM
 * To change this template use File | Settings | File Templates.
 */
@WebService(targetNamespace = "http://com.fusesource.ps/services/Customer")
public interface CustomerService {

    public Customer findCustomerByName(@WebParam(name = "firstName") String firstName,
                                       @WebParam(name = "lastName") String lastName);
}
