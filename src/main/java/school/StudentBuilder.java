package school;

public class StudentBuilder {

    private Student student;

    public StudentBuilder withNameIDAndEmail(String name, String cpf, String email) {
        this.student = new Student(new CPF(cpf), name, new Email(email));
        return this;
    }

    public StudentBuilder withPhone(String code, String number) {
        this.student.addPhone(code, number);
        return this;
    }

    public Student build(){
        return student;
    }
}
