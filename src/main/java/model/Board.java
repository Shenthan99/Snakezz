package model;

import exception.InvalidOccupantException;
import lombok.Data;
import model.cellOccupant.CellOccupant;
import org.apache.commons.lang3.math.NumberUtils;
import utils.PopulateBoardUtil;

import java.util.HashMap;

/**
 * Class defining the snake and ladder board
 */
@Data
public class Board {

    HashMap<Integer, CellOccupant> cells;
    int dimensionOfTheBoard;

    public Board(final int dimensionOfTheBoard) throws InvalidOccupantException {
        this.cells = new HashMap<>();
        this.dimensionOfTheBoard = dimensionOfTheBoard;
        PopulateBoardUtil.populateSnakesAndLadders(cells, dimensionOfTheBoard);
    }

    /**
     * Prints the board
     */
    public void printBoard() {
        final int totalCells = dimensionOfTheBoard * dimensionOfTheBoard;
        for (int currCell = totalCells; currCell >=NumberUtils.INTEGER_ONE; currCell--) {
            if (currCell % dimensionOfTheBoard == 0) {
                System.out.println();
            }
            cells.get(currCell).print();
        }
        System.out.println();
    }
}
