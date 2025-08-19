package mft.simcard.servlet.exception;

public class SimCardNotFoundException extends Exception {
    public SimCardNotFoundException() {
        super("No sim card found");
    }
}
