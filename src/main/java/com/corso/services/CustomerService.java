package com.corso.services;

import com.corso.models.Customer;

public class CustomerService {

    private static CustomerService customerService;

    private CustomerService(){

    } 

    public static CustomerService getInstance() {
        if(customerService == null)
            customerService = new CustomerService();
        return customerService;
    }

    public Customer customerRegister(String name, String pIva) {
        return null;
    }
    
}
