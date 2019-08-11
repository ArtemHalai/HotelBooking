package exceptions;

public class PaymentException extends Exception{
    public PaymentException(Exception e) {
        super(e);
    }

    public PaymentException(String message, Throwable cause) {
        super(message, cause);
    }

    public PaymentException(String message) {
        super(message);
    }
}
