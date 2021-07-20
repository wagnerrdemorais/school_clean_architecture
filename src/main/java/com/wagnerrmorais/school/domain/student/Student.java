package com.wagnerrmorais.school.domain.student;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private CPF cpf;
    private String name;

    private String password;
    private Email email;
    private List<Phone> phones = new ArrayList<>();

    public Student(CPF cpf, String name, Email email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public void addPhone(String code, String number) {
        this.phones.add(new Phone(code, number));
    }

    public String getCpf() {
        return cpf.getNumber();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email.getEmailAddress();
    }

    public List<Phone> getPhones() {
        return phones;
    }
}
