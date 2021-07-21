package com.wagnerrmorais.school.academic.infra.recommendation;

import com.wagnerrmorais.school.academic.application.email.SendRecommendationEmail;
import com.wagnerrmorais.school.academic.domain.student.Student;

public class SendRecommendationWithJavaMail implements SendRecommendationEmail {
    @Override
    public void sendTo(Student student) {
        //all logic here
    }
}
