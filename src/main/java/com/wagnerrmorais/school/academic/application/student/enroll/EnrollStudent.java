package com.wagnerrmorais.school.academic.application.student.enroll;

import com.wagnerrmorais.school.shared.domain.event.EventPublisher;
import com.wagnerrmorais.school.academic.domain.student.EnrolledStudent;
import com.wagnerrmorais.school.academic.domain.student.Student;
import com.wagnerrmorais.school.academic.domain.student.StudentRepository;

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
