package com.wagnerrmorais.school.application.email;

import com.wagnerrmorais.school.domain.student.Student;

public interface SendRecommendationEmail {

    void sendTo(Student student);
}
