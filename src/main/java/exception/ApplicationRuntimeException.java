package exception;

/**
 * Custom runtime exception, for every runtime error in our application.
 */
public class ApplicationRuntimeException extends RuntimeException {

    public ApplicationRuntimeException() {
    }

    public ApplicationRuntimeException(String message) {
        super(message);
    }

    public ApplicationRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
