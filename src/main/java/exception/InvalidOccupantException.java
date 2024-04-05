package exception;

/**
 * Custom exception for Invalid Cell Occupants in a game
 */
public class InvalidOccupantException extends Exception {

    /**
     * Models specified exceptionMsg as a InvalidOccupantException
     * @param exceptionMsg : Exception Message
     */
    public InvalidOccupantException(final String exceptionMsg) {
        super(exceptionMsg);
    }
}
