package com.corso.controllers;

import com.corso.exceptions.InvalidCredentialsException;
import com.corso.models.Customer;
import com.corso.models.dtos.ContactDTO;
import com.corso.services.PortalService;
import com.corso.services.interfaces.IPortalService;

public class ContactController {

    private static final IPortalService portalService = PortalService.getInstance();

    public ContactDTO register(String firstName, String lastName, String phone, String email, String name, String pIva)
            throws InvalidCredentialsException {
        if (firstName == null || lastName == null || phone == null || email == null || name == null || pIva == null)
            throw new InvalidCredentialsException();
        if (firstName.isBlank() || lastName.isBlank() || phone.isBlank() || email.isBlank())
            throw new InvalidCredentialsException();
        if (name.isBlank() && !pIva.isBlank() || !name.isBlank() && pIva.isBlank())
            throw new InvalidCredentialsException();
        Customer customer = null;
        if (!name.isBlank() && !pIva.isBlank())
            customer = portalService.getCustomerService().customerRegister(name, pIva);
        return portalService.getContactService().contactRegister(firstName, lastName, phone, email, customer);
    }

}
