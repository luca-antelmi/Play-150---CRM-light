package com.corso.services;

import com.corso.models.Customer;

public class ContactService {

    private static ContactService contactService;

    private ContactService() {

    }

    public static ContactService getInstance() {
        if (contactService == null)
            contactService = new ContactService();
        return contactService;
    }

    public boolean contactRegister(String firstName, String lastName, String phone, String email) {
        return false;
    }

    public boolean contactRegister(String firstName, String lastName, String phone, String email, Customer customer) {
        return false;
    }

}
