package com.corso.services;

import java.util.*;
import com.corso.models.Contact;
import com.corso.models.Customer;

public class CrmService {

    private static CrmService crmService;
    private ContactService contactService;
    private CustomerService customerService;
    private List<Contact> contacts;
    private Map<String, Customer> customers;

    private CrmService() {
        this.contacts = new ArrayList<>();
        this.customers = new HashMap<>();

    }

    public static CrmService getInstance() {
        if (crmService == null) {
            crmService = new CrmService();
            crmService.contactService = ContactService.getInstance();
            crmService.customerService = CustomerService.getInstance();
        }
        return crmService;
    }

    public ContactService getContactService() {
        return contactService;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public Map<String, Customer> getCustomers() {
        return customers;
    }

}
