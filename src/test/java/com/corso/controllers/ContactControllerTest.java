package com.corso.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.corso.exceptions.InvalidCredentialsException;
import com.corso.models.Customer;
import com.corso.models.dtos.ContactDTO;
import com.corso.services.ContactService;
import com.corso.services.PortalService;
import com.corso.services.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ContactControllerTest {

    @Mock
    private PortalService portalServiceMock;
    @Mock
    private CustomerService customerServiceMock;
    @Mock
    private ContactService contactServiceMock;
    @InjectMocks
    private ContactController controller;

    @Before
    public void setup() {
        controller = new ContactController();
        portalServiceMock = mock(PortalService.class);
        customerServiceMock = mock(CustomerService.class);
        contactServiceMock = mock(ContactService.class);
        MockitoAnnotations.openMocks(this);

    }

    @Test(expected = InvalidCredentialsException.class)
    public void verificaErroreRegisterSeCredenzialiObbligatorieSonoVuote() throws InvalidCredentialsException {
        controller.register("Marco", "", "123", "", "", "");

    }

    @Test(expected = InvalidCredentialsException.class)
    public void verificaErroreRegisterSeCustomerSoloUnaCredenzialeIndicata() throws InvalidCredentialsException {
        controller.register("Marco", "Rossi", "123", "email@email.com", "Azienda", "");
    }

    @Test(expected = InvalidCredentialsException.class)
    public void verificaErroreRegisterSeCredenzialiObbligatorieNull() throws InvalidCredentialsException {
        controller.register("Marco", "Rossi", null, "email@email.com", "Azienda", "456");
    }

    @Test(expected = InvalidCredentialsException.class)
    public void verificaErroreRegisterSeCustomerNull() throws InvalidCredentialsException {
        controller.register("Marco", "Rossi", "123", "email@email.com", null, "456");
    }

    @Test
    public void verificaCorrettoRegister() throws InvalidCredentialsException {
        Customer customer = new Customer("Azienda", "456");
        ContactDTO contactDTO = new ContactDTO("email@email.com", "123");
        when(portalServiceMock.getCustomerService()).thenReturn(customerServiceMock);
        when(customerServiceMock.customerRegister("Azienda", "456")).thenReturn(customer);
        when(portalServiceMock.getContactService()).thenReturn(contactServiceMock);
        when(contactServiceMock.contactRegister("Marco", "Rossi", "123", "email@email.com", customer))
                .thenReturn(contactDTO);
        ContactDTO newDTO = controller.register("Marco", "Rossi", "123", "email@email.com", "Azienda", "456");
        assertEquals(contactDTO.getEmail(), newDTO.getEmail());
        assertEquals(contactDTO.getPhone(), newDTO.getPhone());

    }

}
