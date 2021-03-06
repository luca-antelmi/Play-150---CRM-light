package com.corso.services;

import com.corso.models.Customer;
import com.corso.services.interfaces.ICustomerService;
import java.util.*;

public class CustomerService implements ICustomerService {

    private static CustomerService customerService;

    private CustomerService() {

    }

    public static CustomerService getInstance() {
        if (customerService == null)
            customerService = new CustomerService();
        return customerService;
    }

    public Customer customerRegister(String name, String pIva) {
        Customer customer = findCustomer(pIva);
        if (customer != null)
            return customer;
        else {
            customer = new Customer(name, pIva);
            getCustomers().put(pIva, customer);
            return customer;
        }
    }

    private Map<String, Customer> getCustomers() {
        return PortalService.getInstance().getCustomers();

    }

    public Customer findCustomer(String pIva) {
        return getCustomers().get(pIva);
    }

}
