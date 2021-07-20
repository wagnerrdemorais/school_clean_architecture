package com.wagnerrmorais.school.infrastructureServices.recommendation;

import com.wagnerrmorais.school.application.email.SendRecommendationEmail;
import com.wagnerrmorais.school.domain.student.Student;

public class SendRecommendationWithJavaMail implements SendRecommendationEmail {
    @Override
    public void sendTo(Student student) {
        //all logic here
    }
}
