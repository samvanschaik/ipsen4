package nl.hsleiden.Exceptions;

public class NullCollectionNameException extends RuntimeException{

    public NullCollectionNameException() {
        super("Attempt made to create a DBCollection object when the configured collection name was null or invalid");
    }
}
