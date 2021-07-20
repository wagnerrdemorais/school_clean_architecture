package com.wagnerrmorais.school.domain.student;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(CPF cpf) {
        super("Student not found with cpf: " + cpf.getNumber());
    }
}
