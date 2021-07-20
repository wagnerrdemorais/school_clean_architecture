package com.wagnerrmorais.school.application.student.enroll;

import com.wagnerrmorais.school.domain.student.CPF;
import com.wagnerrmorais.school.domain.student.Student;
import com.wagnerrmorais.school.infrastructureServices.student.repository.StudentInMemoryRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnrollStudentTest {

    @Test
    void shouldPersistStudent() {
        StudentInMemoryRepository repository = new StudentInMemoryRepository();
        EnrollStudent useCase = new EnrollStudent(repository);
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