package com.corso.models.dtos;

public class ContactDTO {

    private String email;
    private String phone;

    public ContactDTO(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }
}
