package utils;

import exception.InvalidOccupantException;
import lombok.experimental.UtilityClass;
import model.cellOccupant.NoOccupant;
import model.cellOccupant.Ladder;
import model.cellOccupant.CellOccupant;
import model.cellOccupant.Snake;

import java.util.HashMap;

/**
 * Utility class for populating snake-and-ladders board
 */
@UtilityClass
public class PopulateBoardUtil {

    int MIN_POS_TO_ADD_ELEMENTS = 2;

    /**
     * Populates the board with snakes and ladders
     * @param cells : Map of cell number to occupant
     * @param dimensionOfTheBoard : Dimensions of the board
     * @throws InvalidOccupantException : In case occupant of a cell is invalid
     */
    public void populateSnakesAndLadders(final HashMap<Integer, CellOccupant> cells, final int dimensionOfTheBoard) throws InvalidOccupantException {
        final int totalNumOfCells = dimensionOfTheBoard * dimensionOfTheBoard;
        for (int cellNum = 0; cellNum <= totalNumOfCells; cellNum++) {
            cells.put(cellNum, new NoOccupant(cellNum, cellNum));
        }
        for (int count = 0; count < dimensionOfTheBoard; count++) {
            int min = MIN_POS_TO_ADD_ELEMENTS;
            int max = totalNumOfCells - 1;
            int start = getRandomNumberInBetween(min, max);
            int end = getRandomNumberInBetween(min, max);
            if (areCellsVacant(cells, start, end)) {
                if (start < end) {
                    cells.put(start, new Ladder(start, end));
                    cells.put(end, new Ladder(start, end));
                } else if (start > end) {
                    cells.put(start, new Snake(start, end));
                    cells.put(end, new Snake(start, end));
                }
            }
        }
    }

    private boolean areCellsVacant(final HashMap<Integer, CellOccupant> cells, int startPosition, int endPosition) {
        return (cells.get(startPosition) instanceof NoOccupant) && (cells.get(endPosition) instanceof NoOccupant);
    }

    private int getRandomNumberInBetween(final int min, final int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}
