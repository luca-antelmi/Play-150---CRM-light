package com.corso.services.interfaces;

import com.corso.models.Customer;
import com.corso.models.dtos.ContactDTO;

public interface IContactService {

    ContactDTO contactRegister(String firstName, String lastName, String phone, String email, Customer customer);

}
