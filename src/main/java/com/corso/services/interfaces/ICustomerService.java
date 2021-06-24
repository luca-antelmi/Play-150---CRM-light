package com.corso.services.interfaces;

import com.corso.models.Customer;

public interface ICustomerService {

    Customer customerRegister(String name, String pIva);

    Customer findCustomer(String pIva);

}
