package exception;

/**
 * Custom exception for validation failures related to Game
 */
public class GameValidationFailedException extends Exception {

    /**
     * Models specified exceptionMsg as a GameValidationFailedException
     * @param exceptionMsg : Exception Message
     */
    public GameValidationFailedException(final String exceptionMsg) {
        super(exceptionMsg);
    }

}
