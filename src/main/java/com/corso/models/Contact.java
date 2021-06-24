package com.corso.models;

public class Contact {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Customer customer;

    public Contact(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public Contact(String firstName, String lastName, String phone, String email, Customer customer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.customer = customer;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getEmail() {
        return this.email;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        String str = "[Contact]: " + "\n" + "\n" + "> First Name: " + firstName + "\n" + "> Last Name: " + lastName + "\n"
                + "> Phone: " + phone + "\n" + "> Email: " + email;
        if (customer != null)
            str = str + "\n" + "> Customer Name: " + customer.getName() + "\n" + "> Customer PIva: " + customer.getPIva();
        return str;
    }

}
