package com.wagnerrmorais.school.academic.application.student.enroll;

import com.wagnerrmorais.school.shared.domain.event.EventPublisher;
import com.wagnerrmorais.school.shared.domain.CPF;
import com.wagnerrmorais.school.academic.domain.student.Student;
import com.wagnerrmorais.school.academic.domain.student.StudentEnrolledLogger;
import com.wagnerrmorais.school.academic.infra.student.repository.StudentInMemoryRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnrollStudentTest {

    @Test
    void shouldPersistStudent() {
        StudentInMemoryRepository repository = new StudentInMemoryRepository();

        EventPublisher publisher = new EventPublisher();
        publisher.addListener(new StudentEnrolledLogger());

        EnrollStudent useCase = new EnrollStudent(repository, publisher);
        EnrollStudentDTO data = new EnrollStudentDTO(
                "fulano",
                "123.456.789-00",
                "email@email.com"
        );

        useCase.execute(data);

        Student foundStudent = repository.findByCPF(new CPF("123.456.789-00"));
        assertEquals("fulano", foundStudent.getName());
        assertEquals("email@email.com", foundStudent.getEmail());
    }

}