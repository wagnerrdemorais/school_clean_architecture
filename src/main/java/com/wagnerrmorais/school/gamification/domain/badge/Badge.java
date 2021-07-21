package com.wagnerrmorais.school.gamification.domain.badge;

import com.wagnerrmorais.school.shared.domain.CPF;

public class Badge {

    private CPF studentCPF;
    private String name;

    public Badge(CPF studentCPF, String name) {
        this.studentCPF = studentCPF;
        this.name = name;
    }

    public CPF getStudentCPF() {
        return studentCPF;
    }

    public String getName() {
        return name;
    }
}
