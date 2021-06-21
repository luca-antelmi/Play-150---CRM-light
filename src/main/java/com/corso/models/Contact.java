package com.corso.models;

public class Contact {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Customer customer;

    public Contact(String firstName, String lastName, String phone, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }
    
}
