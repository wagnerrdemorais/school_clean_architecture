package com.wagnerrmorais.school.domain.recommendation;

import com.wagnerrmorais.school.domain.student.Student;

import java.time.LocalDateTime;

public class Recommendation {

    private Student recomendingStudent;
    private Student recomendedStudent;
    private LocalDateTime recommendationDate;

    public Recommendation(Student recomendingStudent, Student recomendedStudent) {
        this.recomendingStudent = recomendingStudent;
        this.recomendedStudent = recomendedStudent;
        this.recommendationDate = LocalDateTime.now();
    }

    public Student getRecomendingStudent() {
        return recomendingStudent;
    }

    public Student getRecomendedStudent() {
        return recomendedStudent;
    }

    public LocalDateTime getRecommendationDate() {
        return recommendationDate;
    }
}
