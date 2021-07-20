package com.wagnerrmorais.school.infrastructureServices.student;

import com.wagnerrmorais.school.domain.student.PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordMD5Encoder implements PasswordEncoder {

    @Override
    public String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Password encryption error");
        }
    }

    @Override
    public boolean validateEncryptedPassword(String encryptedPassword, String password) {
        return encryptedPassword.equals(encryptPassword(password));
    }
}
