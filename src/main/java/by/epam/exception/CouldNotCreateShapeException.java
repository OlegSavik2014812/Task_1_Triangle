package by.epam.exception;

/**
 * Created by Oleg Savik on 08.10.2017.
 */
public class CouldNotCreateShapeException extends Exception {
    public CouldNotCreateShapeException() {
        super();
    }

    public CouldNotCreateShapeException(Throwable cause) {
        super(cause);
    }

    public CouldNotCreateShapeException(String message) {
        super(message);
    }

    public CouldNotCreateShapeException(String message, Throwable cause) {
        super(message, cause);
    }


}
