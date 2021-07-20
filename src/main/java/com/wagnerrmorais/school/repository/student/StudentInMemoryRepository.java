package com.wagnerrmorais.school.repository.student;

import com.wagnerrmorais.school.domain.student.CPF;
import com.wagnerrmorais.school.domain.student.Student;
import com.wagnerrmorais.school.domain.student.StudentNotFoundException;
import com.wagnerrmorais.school.domain.student.StudentRepository;

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
                .filter(student -> student.getCpf().equals(cpf.getNumber()))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException(cpf));
    }

    @Override
    public List<Student> findAllEnrolledStudents() {
        return this.enrolled;
    }
}
