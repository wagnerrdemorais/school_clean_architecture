package com.wagnerrmorais.school.infrastructureServices.student.repository;

import com.wagnerrmorais.school.domain.student.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements com.wagnerrmorais.school.domain.student.StudentRepository {

    private final Connection connection;

    public StudentRepository(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void enroll(Student student) {
        try {
            String sql = "INSERT INTO STUDENT VALUES(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, student.getCpf().getNumber());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.execute();

            sql = "INSERT INTO PHONE VALUES (?, ?)";
            ps = connection.prepareStatement(sql);

            for(Phone phone : student.getPhones()) {
                ps.setString(1, phone.getCode());
                ps.setString(2, phone.getNumber());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Student findByCPF(CPF cpf) {
        try {
            String sql = "SELECT id, name, email FROM Student WHERE cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getNumber());

            ResultSet rs = ps.executeQuery();
            boolean encontrou = rs.next();
            if (!encontrou) {
                throw new StudentNotFoundException(cpf);
            }

            String name = rs.getString("name");
            Email email = new Email(rs.getString("email"));
            Student encontrado = new Student(cpf, name, email);

            Long id = rs.getLong("id");
            sql = "SELECT ddd, numero FROM PHONE WHERE student_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String numero = rs.getString("number");
                String ddd = rs.getString("code");
                encontrado.addPhone(ddd, numero);
            }

            return encontrado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> findAllEnrolledStudents() {
            try {
                String sql = "SELECT id, cpf, name, email FROM STUDENT";
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<Student> students = new ArrayList<>();

                while (rs.next()) {
                    CPF cpf = new CPF(rs.getString("cpf"));
                    String name = rs.getString("name");
                    Email email = new Email(rs.getString("email"));
                    Student student = new Student(cpf, name, email);

                    long id = rs.getLong("id");
                    String phoneSql = "SELECT ddd, number FROM PHONE WHERE student_id = ?";
                    PreparedStatement psPhone = connection.prepareStatement(phoneSql);
                    psPhone.setLong(1, id);
                    ResultSet rsTelefone = psPhone.executeQuery();
                    while (rsTelefone.next()) {
                        String numero = rsTelefone.getString("number");
                        String ddd = rsTelefone.getString("code");
                        student.addPhone(ddd, numero);
                    }

                    students.add(student);
                }

                return students;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
}
