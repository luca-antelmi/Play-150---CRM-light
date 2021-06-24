package com.corso;

import com.corso.controllers.ContactController;
import com.corso.models.Contact;
import com.corso.models.Customer;
import com.corso.services.PortalService;

public class CallCenter {

    public static void main(String[] args) {

        ContactController controller = new ContactController();

        try {
            controller.register("Marco", "Rossi", "123", "email@gmail.com", "Coca Cola", "321");
            controller.register("Mario", "Bianchi", "456", "email@hotmail.it", "", ""); // inserimento di un contatto
                                                                                        // senza customer
            controller.register("Stefano", "Verdi", "789", "email@libero.it", "Fanta", "987");
        } catch (Exception e) {
            e.getMessage();
        }

        System.out.println("Stampa dei primi contact inseriti nel db e relativi customer");
        System.out.println();
        PortalService portal = PortalService.getInstance();

        for (Contact item : portal.getContacts()) {
            System.out.println(item.toString());
            System.out.println();
        }

        System.out.println();

        for (Customer item : portal.getCustomers().values()) {
            System.out.println(item.toString());
            System.out.println();
        }

        System.out.println("Inserimento di un nuovo contact con un customer che gia esiste nel db");
        System.out.println();

        try {
            controller.register("Gloria", "Gialli", "145", "email@email.com", "Coca Cola", "321");
        } catch (Exception e) {
            e.getMessage();
        }

        for (Contact item : portal.getContacts()) {
            System.out.println(item.toString());
            System.out.println();
        }

        System.out.println();

        for (Customer item : portal.getCustomers().values()) {
            System.out.println(item.toString());
            System.out.println();
        }

        System.out.println(
                "Inserimento di un contact gia esistente nel db, ma con alcuni nuovi valori e con customer associato non inserito");
        System.out.println("Stefano Arancioni sovrascrive il precedente Stefano Verdi poiche hanno lo stesso phone");
        System.out.println();

        try {
            controller.register("Stefano", "Arancioni", "789", "email@yahoo.it", "", "");
        } catch (Exception e) {
            e.getMessage();
        }

        for (Contact item : portal.getContacts()) {
            System.out.println(item.toString());
            System.out.println();
        }

        System.out.println();

        for (Customer item : portal.getCustomers().values()) {
            System.out.println(item.toString());
            System.out.println();
        }

        System.out.println(
                "Inserimento di un contact gia esistente nel db, ma con alcuni nuovi valori e con nuovo customer associato");
        System.out.println("Mia Rossi sovrascrive il precedente Mario Bianchi poiche hanno la stessa email");
        System.out.println();

        try {
            controller.register("Mia", "Rossi", "456", "email@hotmail.it", "Pepsi", "654");
        } catch (Exception e) {
            e.getMessage();
        }

        for (Contact item : portal.getContacts()) {
            System.out.println(item.toString());
            System.out.println();
        }

        System.out.println();

        for (Customer item : portal.getCustomers().values()) {
            System.out.println(item.toString());
            System.out.println();
        }

    }
}
