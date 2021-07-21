package com.wagnerrmorais.school.domain.student;

import java.util.ArrayList;
import java.util.List;

//Aggregate Root
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
        if(phones.size() == 2){
            throw new MaximumNumberOfPhonesException("Maximum of phones reached!");
        }
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
