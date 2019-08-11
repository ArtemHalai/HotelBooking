package exceptions;

public class NoAvailableRoomException extends Exception {

    public NoAvailableRoomException(Exception e) {
        super(e);
    }

    public NoAvailableRoomException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoAvailableRoomException(String message) {
        super(message);
    }
}
