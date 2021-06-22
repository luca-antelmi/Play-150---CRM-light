package com.corso.controllers;

import com.corso.exceptions.InvalidCredentialsException;
import com.corso.models.Customer;
import com.corso.services.CrmService;

public class ContactController {

    private static final CrmService crmService = CrmService.getInstance();

    public boolean register(String firstName, String lastName, String phone, String email, String name, String pIva)
            throws InvalidCredentialsException {
        if (firstName.isBlank() || lastName.isBlank() || phone.isBlank() || email.isBlank())
            throw new InvalidCredentialsException();
        if (name.isBlank() && !pIva.isBlank() || !name.isBlank() && pIva.isBlank())
            throw new InvalidCredentialsException();
        if (!name.isBlank() && !pIva.isBlank()) {
            Customer customer = crmService.getCustomerService().customerRegister(name, pIva);
            return crmService.getContactService().contactRegister(firstName, lastName, phone, email, customer);
        }
        else
            return crmService.getContactService().contactRegister(firstName, lastName, phone, email);
    }

}
