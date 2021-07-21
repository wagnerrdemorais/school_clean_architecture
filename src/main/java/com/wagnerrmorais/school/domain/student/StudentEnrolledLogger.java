package com.wagnerrmorais.school.domain.student;

import com.wagnerrmorais.school.domain.EventListener;

import java.time.format.DateTimeFormatter;

public class StudentEnrolledLogger extends EventListener {

    @Override
    protected void reactTo(Event event) {
        String formattedMoment = event.moment().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.printf("Student with cpf: %s enrolled at: %s%n",
                ((EnrolledStudent) event).getStudentCPF().getNumber(),
                formattedMoment);
    }

    @Override
    protected boolean shouldProcess(Event event) {
        return event instanceof EnrolledStudent;
    }
}
