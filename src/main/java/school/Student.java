package school;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private CPF cpf;
    private String name;
    private Email email;
    private List<Phone> phones = new ArrayList<>();

    public Student(CPF cpf, String name, Email email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public void addPhone(String code, String number){
        this.phones.add(new Phone(code, number));
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public List<Phone> getPhones() {
        return phones;
    }
}
