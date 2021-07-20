package school;

public class Phone {

    private String code;
    private String number;

    public Phone(String code, String number) {
        //should validate
        if (code == null || number == null) {
            throw new IllegalArgumentException("Code and number should be provided");
        }

        if (!code.matches("\\d{2}")) {
            throw new IllegalArgumentException("Invalid Code");
        }

        if (!number.matches("\\d{8}|\\d{9}")) {
            throw new IllegalArgumentException("Invalid number");
        }

        this.code = code;
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public String getNumber() {
        return number;
    }
}
