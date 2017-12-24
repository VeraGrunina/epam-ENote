package generalPackage.exception;

/**
 * Custom runtime exception, for runtime error for invalid entity.
 */
public class UnprocessableEntityException extends ApplicationRuntimeException {

    public UnprocessableEntityException(String message) {
        super(message);
    }
}
