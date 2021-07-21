package com.wagnerrmorais.school.application.student.enroll;

import com.wagnerrmorais.school.domain.EventPublisher;
import com.wagnerrmorais.school.domain.student.EnrolledStudent;
import com.wagnerrmorais.school.domain.student.Student;
import com.wagnerrmorais.school.domain.student.StudentRepository;

public class EnrollStudent {

    private final StudentRepository repository;
    private final EventPublisher publisher;

    public EnrollStudent(StudentRepository repository, EventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    public void execute(EnrollStudentDTO data){
        Student student = data.createStudent();
        repository.enroll(student);
        EnrolledStudent event = new EnrolledStudent(student.getCpf());
        publisher.publishEvent(event);
    }
}
