package com.wagnerrmorais.school.academic.application.email;

import com.wagnerrmorais.school.academic.domain.student.Student;

public interface SendRecommendationEmail {

    void sendTo(Student student);
}
