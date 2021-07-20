package school;

public class Email {

    //Value Object

    private String email;

    public Email(String email) {
        if(email == null || !email.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
            throw new IllegalArgumentException("Invalid E-mail!");
        }
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
