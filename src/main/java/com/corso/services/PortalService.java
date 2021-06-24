package com.corso.services;

import java.util.*;
import com.corso.models.Contact;
import com.corso.models.Customer;
import com.corso.services.interfaces.IPortalService;

public class PortalService implements IPortalService {

    private static PortalService portalService;
    private ContactService contactService;
    private CustomerService customerService;
    private List<Contact> contacts;
    private Map<String, Customer> customers;

    private PortalService() {
        this.contacts = new ArrayList<>();
        this.customers = new HashMap<>();

    }

    public static PortalService getInstance() {
        if (portalService == null) {
            portalService = new PortalService();
            portalService.contactService = ContactService.getInstance();
            portalService.customerService = CustomerService.getInstance();
        }
        return portalService;
    }

    public ContactService getContactService() {
        return this.contactService;
    }

    public CustomerService getCustomerService() {
        return this.customerService;
    }

    public List<Contact> getContacts() {
        return this.contacts;
    }

    public Map<String, Customer> getCustomers() {
        return this.customers;
    }

}
