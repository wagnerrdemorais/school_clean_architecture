package com.wagnerrmorais.school.academic.application.student.enroll;

import com.wagnerrmorais.school.academic.domain.student.Student;
import com.wagnerrmorais.school.academic.domain.student.StudentBuilder;

public class EnrollStudentDTO {

    private String name;
    private String cpf;
    private String email;

    public EnrollStudentDTO(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public Student createStudent() {
        return new StudentBuilder()
                .withNameIDAndEmail(name, cpf, email)
                .build();
    }
}
