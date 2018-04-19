package nl.hsleiden.Exceptions;

public class NullDBNameException extends RuntimeException {

    public NullDBNameException() {
        super("Attempt made to create a DBCollection object when the configured database name was null or " +
                "invalid");
    }
}
