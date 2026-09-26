package exceptions;

public class InvalidAccountOperationException extends RuntimeException {

    public InvalidAccountOperationException(String message) {
        super(message);
    }
}