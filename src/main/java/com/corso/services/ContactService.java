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
        Contact contact;
        if (customer == null)
            contact = new Contact(firstName, lastName, phone, email);
        else
            contact = new Contact(firstName, lastName, phone, email, customer);
        Iterator<Contact> iterator = getContacts().iterator();

        while (iterator.hasNext()) {
            Contact contactToIterate = iterator.next();
            if (comparator.compare(contactToIterate, contact) == 1) { // iterator.next e contact sono uguali
                if (contact.getCustomer() == null && contactToIterate.getCustomer() != null)
                    contact.setCustomer(contactToIterate.getCustomer());
                iterator.remove(); // cancello il vecchio contact dalla lista di tutti i contact
                break; // esco dal ciclo poiche ho trovato il vecchio contact e l'ho eliminato
            }
        }
        getContacts().add(contact);
        return contact;
    }

    private List<Contact> getContacts() {
        return CrmService.getInstance().getContacts();
    }

}
