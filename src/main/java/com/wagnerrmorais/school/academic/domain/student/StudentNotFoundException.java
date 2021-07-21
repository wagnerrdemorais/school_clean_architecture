package com.wagnerrmorais.school.academic.domain.student;

import com.wagnerrmorais.school.shared.domain.CPF;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(CPF cpf) {
        super("Student not found with cpf: " + cpf.getNumber());
    }
}
