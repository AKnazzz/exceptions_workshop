package task_4.exceptions;

public class UnauthorizedAccessAttemptException extends Exception{
    public UnauthorizedAccessAttemptException(String message) {
        super(message);
    }
}
