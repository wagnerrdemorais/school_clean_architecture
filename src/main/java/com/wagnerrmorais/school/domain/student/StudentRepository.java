package com.wagnerrmorais.school.domain.student;

import java.util.List;

public interface StudentRepository {

    void enroll(Student student);

    Student findByCPF(CPF cpf);

    List<Student> findAllEnrolledStudents();

}
