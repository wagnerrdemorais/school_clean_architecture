package com.wagnerrmorais.school.academic.domain.student;

import com.wagnerrmorais.school.shared.domain.CPF;

import java.util.List;

public interface StudentRepository {

    void enroll(Student student);

    Student findByCPF(CPF cpf);

    List<Student> findAllEnrolledStudents();

}
