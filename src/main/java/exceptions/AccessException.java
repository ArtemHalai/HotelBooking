package exceptions;

public class AccessException extends Exception {

    public AccessException(Exception e) {
        super(e);
    }

    public AccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessException(String message) {
        super(message);
    }
}
