package com.wagnerrmorais.school;

import com.wagnerrmorais.school.application.student.enroll.EnrollStudent;
import com.wagnerrmorais.school.application.student.enroll.EnrollStudentDTO;
import com.wagnerrmorais.school.infrastructureServices.student.repository.StudentInMemoryRepository;

public class EnrollStudentByCommandLine {

    public static void main(String[] args) {


        String name = "Someone";
        String cpf = "123.456.789-00";
        String email = "name@someemail.com";

        EnrollStudent enrollStudent = new EnrollStudent(new StudentInMemoryRepository());

        //Command
        enrollStudent.execute(new EnrollStudentDTO(name, cpf, email));


    }
}