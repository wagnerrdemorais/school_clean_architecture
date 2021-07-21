package com.wagnerrmorais.school.academic.domain.student;

import com.wagnerrmorais.school.shared.domain.CPF;

import java.time.LocalDateTime;

public class EnrolledStudent implements Event {

    private final CPF studentCPF;
    private final LocalDateTime moment;

    public EnrolledStudent(CPF studentCPF) {
        this.studentCPF = studentCPF;
        this.moment = LocalDateTime.now();
    }

    @Override
    public LocalDateTime moment() {
        return this.moment;
    }

    public CPF getStudentCPF() {
        return studentCPF;
    }
}
