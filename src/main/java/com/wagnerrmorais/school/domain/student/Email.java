package com.wagnerrmorais.school.domain.student;

public class Email {

    //Value Object

    private String emailAddress;

    public Email(String emailAddress) {
        if(emailAddress == null || !emailAddress.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
            throw new IllegalArgumentException("Invalid E-mail!");
        }
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
