package com.corso.services;

import com.corso.models.Contact;
import com.corso.models.Customer;
import com.corso.utilities.ContactsComparator;
import java.util.*;

public class ContactService {

    private static ContactService contactService;
    private ContactsComparator comparator;

    private ContactService() {
        this.comparator = new ContactsComparator();
    }

    public static ContactService getInstance() {
        if (contactService == null)
            contactService = new ContactService();
        return contactService;
    }

    public Contact contactRegister(String firstName, String lastName, String phone, String email, Customer customer) {
        // prima di fare la registrazione del contact bisogna vedere se il customer è
        // null,
        // in caso affermativo si lancerà il costruttore di contact senza il customer
        // in caso negativo si lancerò il costruttore di contact con il customer
        Iterator<Contact> iterator = getContacts().iterator();
        while(iterator.hasNext()){
            if(iterator != null){
                
            }
        }
        return null;
    }

    private List<Contact> getContacts() {
        return CrmService.getInstance().getContacts();
    }

}
