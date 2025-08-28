package mft.simcard.servlet.exception;

public class SimCardHasAlreadyExistException extends Exception {
    public SimCardHasAlreadyExistException() {
        super("Sim card has already exist. please pick a different sim card.");
    }
}
