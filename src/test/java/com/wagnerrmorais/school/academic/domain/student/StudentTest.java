package com.wagnerrmorais.school.academic.domain.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private Student student;

    @BeforeEach
    void setUp() {
        this.student = new StudentBuilder()
                .withNameIDAndEmail(
                "Tiozinho",
                "123.456.789-10",
                "tiozinho@email.com")
                .build();
    }

    @Test
    void shouldAllowToAddOnePhoneNumber(){
        this.student.addPhone("11", "999999999");
        assertEquals(1, this.student.getPhones().size());
    }

    @Test
    void shouldAllowToAddTwoPhoneNumber(){
        this.student.addPhone("11", "999999999");
        this.student.addPhone("11", "888888888");
        assertEquals(2, this.student.getPhones().size());
    }

    @Test
    void shouldNotAllowToAddMoreThanTwoPhoneNumber(){
        assertThrows(MaximumNumberOfPhonesException.class, () -> {
            this.student.addPhone("11", "999999999");
            this.student.addPhone("11", "888888888");
            this.student.addPhone("11", "777777777");
        });
    }

}