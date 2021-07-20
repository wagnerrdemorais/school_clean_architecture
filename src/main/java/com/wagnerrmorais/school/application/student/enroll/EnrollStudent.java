package com.wagnerrmorais.school.application.student.enroll;

import com.wagnerrmorais.school.domain.student.Student;
import com.wagnerrmorais.school.domain.student.StudentRepository;

public class EnrollStudent {

    private final StudentRepository repository;

    public EnrollStudent(StudentRepository repository) {
        this.repository = repository;
    }

    public void execute(EnrollStudentDTO data){
        Student student = data.createStudent();
        repository.enroll(student);
    }
}
