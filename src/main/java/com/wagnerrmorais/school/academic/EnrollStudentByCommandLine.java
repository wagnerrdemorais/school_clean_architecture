package com.wagnerrmorais.school.academic;

import com.wagnerrmorais.school.academic.application.student.enroll.EnrollStudent;
import com.wagnerrmorais.school.academic.application.student.enroll.EnrollStudentDTO;
import com.wagnerrmorais.school.academic.domain.EventPublisher;
import com.wagnerrmorais.school.academic.domain.student.StudentEnrolledLogger;
import com.wagnerrmorais.school.academic.infra.student.repository.StudentInMemoryRepository;

public class EnrollStudentByCommandLine {

    public static void main(String[] args) {

        String name = "Someone";
        String cpf = "123.456.789-00";
        String email = "name@someemail.com";


        EventPublisher publisher = new EventPublisher();
        publisher.addListener(new StudentEnrolledLogger());

        EnrollStudent enrollStudent = new EnrollStudent(new StudentInMemoryRepository(), publisher);

        //Command
        enrollStudent.execute(new EnrollStudentDTO(name, cpf, email));

    }
}
