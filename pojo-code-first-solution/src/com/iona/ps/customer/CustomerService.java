package com.iona.ps.customer;



public interface CustomerService {
    Customer findCustomerByName(
         String firstName, 
         String lastName
    );
}

