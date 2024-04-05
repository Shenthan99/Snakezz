package utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * Utility class for Validating Moves
 */
@UtilityClass
public class MoveValidator {

    /**
     * Validates if the move is valid
     * @param positionToValidate : final position to validate
     * @param maxPosition : max position that can be reached
     * @return boolean signifying whether the move is valid or not
     */
    public boolean isValidMove(final int positionToValidate, final int maxPosition) {
        return positionToValidate <= maxPosition && positionToValidate > NumberUtils.INTEGER_ZERO;
    }
}
