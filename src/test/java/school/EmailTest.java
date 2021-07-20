package school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void shouldNotAllowToCreateInvalidEmail(){
        assertThrows(IllegalArgumentException.class,
                () -> new Email(null));

        assertThrows(IllegalArgumentException.class,
                () -> new Email(""));

        assertThrows(IllegalArgumentException.class,
                () -> new Email("something"));
    }

    @Test
    void shouldAllowToCreateValidEmail(){
        Email email = new Email("something@bla.com");
        assertNotNull(email);
    }



}