package com.corso.services.interfaces;

import com.corso.models.Contact;
import com.corso.models.Customer;
import com.corso.services.ContactService;
import com.corso.services.CustomerService;
import java.util.*;

public interface IPortalService {

    ContactService getContactService();

    CustomerService getCustomerService();

    List<Contact> getContacts();

    Map<String, Customer> getCustomers();

}
