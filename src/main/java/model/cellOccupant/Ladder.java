package model.cellOccupant;

import exception.InvalidOccupantException;

import java.util.Optional;

/**
 * Extension over Cell Occupant to define Ladder
 */
public class Ladder extends CellOccupant {

    static char OCCUPANT_CODE = 'L';

    public Ladder(final int startPosition, final int endPosition) throws InvalidOccupantException {
        super(startPosition, endPosition);
    }

    @Override
    public Optional<String> getEncounterMessage(final int currPosition) {
        if (currPosition == getStartPosition()) {
            return Optional.of("Wow ! You got a ladder");
        }
        return Optional.empty();
    }

    @Override
    public void print() {
        System.out.print(getStringForBoardPrinting(getEndPosition(), OCCUPANT_CODE));
    }

    @Override
    protected void validateOccupancy(final int startPosition, final int endPosition) throws InvalidOccupantException {
        if (startPosition >= endPosition) {
            throw new InvalidOccupantException("Start position should be less than end position for a ladder.");
        }
    }
}
