package com.wagnerrmorais.school.academic.domain.student;

import com.wagnerrmorais.school.shared.domain.CPF;
import com.wagnerrmorais.school.shared.domain.event.Event;
import com.wagnerrmorais.school.shared.domain.event.EventType;

import java.time.LocalDateTime;
import java.util.Map;

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

    @Override
    public EventType type() {
        return EventType.ENROLLED_STUDENT;
    }

    @Override
    public Map<String, Object> eventInfo() {
        return Map.of("cpf", studentCPF);
    }

    public CPF getStudentCPF() {
        return studentCPF;
    }
}
