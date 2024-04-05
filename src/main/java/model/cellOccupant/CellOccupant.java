package model.cellOccupant;

import exception.InvalidOccupantException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Optional;

/**
 * Abstract class for CellOccupant. The cell can have a snake or a ladder or can be left blank.
 */
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class CellOccupant {

    int startPosition;
    int endPosition;

    public CellOccupant(final int startPosition, final int endPosition) throws InvalidOccupantException {
        validateOccupancy(startPosition, endPosition);
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    /**
     * Message to print when the given cell is encountered
     * @return Optional of message
     */
    public abstract Optional<String> getEncounterMessage(final int currPosition);

    /**
     * Prints the cell content (identification code along with cell number)
     */
    public abstract void print();

    /**
     * String to be printed for board printing
     * @param cellNumber : Cell Number
     * @param printCode : Code corresponding to the occupant type
     * @return String to be printed for board printing
     */
    protected String getStringForBoardPrinting(final int cellNumber, final char printCode) {
        final String paddedCellNumber = String.format("%03d", cellNumber);
        return String.format(" %c(%s) ", printCode, paddedCellNumber);
    }

    /**
     * Validates if start & end position are valid for given occupant
     * @param startPosition : Start Position of Occupant
     * @param endPosition : End Position of Occupant
     * @throws InvalidOccupantException : In case positions are invalid for the given occupant
     */
    protected abstract void validateOccupancy(final int startPosition, final int endPosition) throws InvalidOccupantException;
}
