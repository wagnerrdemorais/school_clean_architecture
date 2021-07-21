package com.wagnerrmorais.school.academic.infra.student.repository;

import com.wagnerrmorais.school.shared.domain.CPF;
import com.wagnerrmorais.school.academic.domain.student.Student;
import com.wagnerrmorais.school.academic.domain.student.StudentNotFoundException;
import com.wagnerrmorais.school.academic.domain.student.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentInMemoryRepository implements StudentRepository {

    private List<Student> enrolled = new ArrayList<>();

    @Override
    public void enroll(Student student) {
        this.enrolled.add(student);
    }

    @Override
    public Student findByCPF(CPF cpf) {
        return this.enrolled.stream()
                .filter(student -> student.getCpf().getNumber().equals(cpf.getNumber()))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException(cpf));
    }

    @Override
    public List<Student> findAllEnrolledStudents() {
        return this.enrolled;
    }
}
