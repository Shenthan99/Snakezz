package model.cellOccupant;

import exception.InvalidOccupantException;

import java.util.Optional;

/**
 * No Occupant signifies that cell is vacant (no snake or ladder)
 */
public class NoOccupant extends CellOccupant {

    static char OCCUPANT_CODE = 'N';

    public NoOccupant(int startPosition, int endPosition) throws InvalidOccupantException {
        super(startPosition, endPosition);
    }

    @Override
    public Optional<String> getEncounterMessage(final int currPosition) {
        return Optional.empty();
    }

    @Override
    public void print() {
       System.out.print(getStringForBoardPrinting(getEndPosition(), OCCUPANT_CODE));
    }

    @Override
    protected void validateOccupancy(final int startPosition, final int endPosition) throws InvalidOccupantException {
        if (startPosition != endPosition) {
            throw new InvalidOccupantException("Start position should be equal to end position in case there no occupant.");
        }
    }
}
