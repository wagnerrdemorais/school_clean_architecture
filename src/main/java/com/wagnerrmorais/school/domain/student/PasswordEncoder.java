package com.wagnerrmorais.school.domain.student;

public interface PasswordEncoder {

    String encryptPassword(String password);

    boolean validateEncryptedPassword(String encryptedPassword, String password);
}
