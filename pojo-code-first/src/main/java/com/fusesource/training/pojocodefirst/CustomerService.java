package com.fusesource.training.pojocodefirst;



public interface CustomerService {
    Customer findCustomerByName(
            String firstName,
            String lastName
    );
}

