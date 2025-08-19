package mft.simcard.servlet.exception;

public class PersonNotFoundException extends Exception {
    public PersonNotFoundException() {
        super("Person not found");
    }
}
